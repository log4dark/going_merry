# Java
Drop in Java :love_you_gesture:  

## Contents
> + 01 데이터 타입 (Data Type)
> + 02 연산자
> + 03 제어문
> + 04 클래스 (Class)
> + 05 상속
> + 06 인터페이스 (Interface)
> + 07 중첩 클래스와 중첩 인터페이스 (Nested Class and Nested Interface)
> + 08 예외 처리 (Exception)
> + 09 스레드 (Thread)
> + 10 제너릭 (Generic)
> + 11 자바 API (library)
>   + java.lang
>   + java.util
>   + java.time
> + 12 자바 I/O 입출력
> + 13 자바 네트워킹

## 00 Start...
API Document link: <https://docs.oracle.com/javase/8/docs/api/>

### 자바란?
- 객체지향 언어
- Garbage Collector
- JVM(Java Virtual Machine) - One source multi-use
- 함수적 스타일 코딩 지원 -> 람다식(Lambda Expression)
 
## 01 데이터 타입 (Data Type)
### 기본 타입(Primitive Type)
#### 정수 타입
- byte: 1byte - 바이너리 데이터 처리할 때 사용 (파일, 네트워크)
- char: 2byte, 0~2<sup>16-1</sup> (유니코드: \u0000~\uFFFF)
- short: 2byte
- int: 4byte
- long: 8byte
 
#### 실수 타입
- float: 4byte
- double: 8byte
 
### 참조 타입(Reference Type)
배열, Enum, 클래스, 인터페이스 타입으로 객체(Object)의 주소값을 저장하는 타입 - 변수는 스택영역, 객체는 힙 영역  

#### String 타입
...
```java
// 문자열 리터럴이 동일하면 같은 객체를 공유
String name1 = "penny"; 
String name2 = "penny";
name1 == name2; // true (주소 비교)

// name3과 name4는 서로 다른 객체
String name3 = new String("penny");
String name4 = new String("penny");
name3 == name4; // false

// String 값 비교는 equals 메소드 사용. 
name3.equals(name4); // true
```

#### 배열 타입
배열 선언
```java
int[] array; // 타입[] 변수
int array[]; // 타입 변수[]
```

배열 선언과 값 할당
```java
String[] name1 = {"dark", "penny", "jisung");
String[] name2 = null;
name2 = new String[] {"dark", "penny", "jisung");
// 배열 객체의 주소 출력
System.out.printf("name=%x\n", System.identityHashCode(name));
```

커맨드 라인 입력
```java
// $ java TcpServer 127.0.0.1 20000 
public String void main(String[] args) {
	args.length; // 2
    args[0]; // 127.0.0.1
    args[1]; // 20000 
    ...
}
```

다차원 배열
```java
int[][] scores = new int[2][3];
scores.length; // 2
scores[0].length; // 3
scores[1].length; // 3
```

#### Enum 타입
Enum 선언
```java
// BloodType.java
public enum BloodType { // 파일명과 Enum명이 같아야 함
    A, // 요넘 하나가 객체임
    B,
    AB,
    O
}
```

Enum 객체의 메소드
- name(): 열거 객체의 문자열 리턴
- ordinal(): 열거 객체의 순번(0부터 시작)을 리턴
- valueOf(): 주어진 문자열의 열거 객체를 리턴
- compareTo(): 열거 객체를 비교해서 순번 '차이'를 리턴
- values(): 모든 열거 객체들을 배열로 리턴  
 
```java
BloodType bt1 = Bloodtype.AB;
String name = bt1.name(); // "AB"
int ordinal = bt1.ordinal(); // 2
bloodType = bt1.valueOf("O"); // O

BloodType bt2 = BloodType.A;
bt1.compareTo(bt2); // -2
bt2.compareTo(bt1); // 2

BloodType[] btArr = BloodType.values();
for(BloodType bt3 : btArr) {
	System.out.println(bt3); // A, B, AB, O
}
```  

C/C++ style Enum[^1]
```java
public enum ErrorCode {
    SUCCESS(0), // SUCCESS 객체를 생성, 생성자 구현 후 int 0 으로 설정
    ERROR(1),

    UNDER_CONSTRUCTION(9000);
    
    private final int errorCode;
    ErrorCode(int errorCode) { this.errorCode = errorCode; }
    public int value() { return errorCode; }
}
ErrorCode.UNDER_CONSTRUCTION.value(); // 9000
```

## 연산자
### 연산자(Operator) 종류
- 산술: +, -, *, /, %
- 부호: +, -  // 음수와 양수의 부호
- 대입: =, +=, -=, *=, /=, %=, &=, ^=, |=, <<=, >>=, >>>=
- 증감: ++, --
- 비교: ==, !=, >, <, >=, <=, instanceof
- 논리: !, &, |, &&, ||
- 조건: (조건식)?A:B
- 비트: ~, &, |, ^
- 쉬프트: >>, <<, >>>
 
### 연산자 우선순위
1. 증감(++, --), 부호(+, -), 비트(~), 논리(!)
2. 산술(*, /, %)
3. 산술(+, -)
4. 쉬프트(<<, >>, >>>)
5. 비교(<, >, <=, >=, instanceof)
6. 비교(==, !=)
7. 논리(&)
8. 논리(^)
9. 논리(|)
10. 논리(&&)
11. 논리(||)
12. 조건(?:)
13. 대입(=, +=, -=, *=, /=, %=, &=, ^=, |=, <<=, >>=, >>>=)


## 제어문
### 조건문
- if
- switch
 
### 반복문
- for
- while
- do-while
 
### 기타
- break
- continue

**Java 5 for loop syntax**  
(1)배열에서 가져올 값이 있는지 평가, 있으면 (2)->(3)->(1) 이고, 없으면 `for`문 종료
```java
for ( (2)타입 변수 : (1)배열 ) {
	(3)실행문;
}

int[]scores = {95, 90, 87, 89, 97};
for (int scores : scores) {
	// processing...
}
```  

## 04 클래스 (Class)
### 객체지향 프로그래밍
객체간의 상호작용, 메소드 호출(메시지 전달), 객체간의 관계.  

#### 객체란?
물리적으로 존재하거나 추상적으로 존재하며 자신만의 속성을 가지고 식별되는 개체이다.  
객체는 속성과 동작으로 구성되어 있고, 자바에서는 각각을 필드(**field**)와 메소드(**method**)라고 한다.  
그러면, 클래스는? 객체를 생성/만들기 위한 템플릿(Template)이다.

**Instance vs. Object**[^2]  
예를 들어서 그릇에 사과 5개가 있고, 각각의 사과는 사과 타입의 객체이고, 둥글고, 크고등의 특징을 가지고 있다.   
위의 내용을 프로그래밍 관점에서 보면,  
Apple 클래스에 변수로 shape:둥글고, size:크다 등을 가져야 하고,   
그릇에 5개의 사과를 표현하기 위해서는 5개의 사과를 만들어야(**인스턴스화**) 한다.   
`Apple apple1, Apple apple2, Apple apple3 etc...`. 

즉, 클래스로 부터 객체를 만드는 과정을 인스턴스화라고 하고, 클래스로 부터 만들어진 객체를 해당 클래스의 인스턴스(instance)라고 한다.

#### 클래스간의 관계
- 영속적인 관계가 아닐 경우 (멤버가 아님)
  - Dependency: *uses a*
- 영속적인 관계일 경우 (멤버)
  - Association: *uses a* - Association은 클래스간의 관계가 논리적으로 전체(집합)와 부분의 관계일 경우, Aggregation과 Composition으로 나눌 수 있다.
    - Aggregation: *has a* (...는...를 가짐)
    - Composition: *owns a*
- 영속적인 관계일 경우 (상속)
  - Inheritance: *is a*

```
// 객체간의 관계
                         machine
                            ^
                            | 상속 관계 (Inheritance)
person --사용(Dependency)--> car
                            ^
                            | 집합 관계 (Association)
                +-----------|------------+
                |           |            |
              engine       tire        handle
```

### 클래스 선언, 객체 생성과 클래스 변수
```java
// 클래스 선언
public class Car {
  ...
}

// 'new' 연산자로 car 객체를 생성
Car car = new Car();
```

### 클래스의 구성 멤버
```java
public class ClassName {
  // 필드 - 데이터 저장
  int fieldName;
  
  // 생성자 - 객체 생성 시, 초기화
  ClassName() { ... }
  
  // 메소드 - 객체의 동작
  void methodName() { ... }
}
```
필드를 클래스 멤버 변수로 부르기도 함.  
필드 선언과 동시에 초기화 가능하고 생략 시, 필드 초기값은 정수/실수 티입은 '0', 논리 타입은 'false', 참조 타입은 'null' 이다.

### 생성자
객체의 생성 시, 초기화 역할 

#### 다른 생성자 호출 (this())
```java
클래스( [매개변수선언, ...] ) {
  this( 매개변수, ..., 값, ... ); // 클래스의 다른 생성자 호출
}

Car(String model) {
  this(model, 250);
}

Car(String model, int maxSpeed) {
  this.model = model;
  this.maxSpeed = maxSpeed;
}
```

### 메소드
객체의 동작 역할  

#### 메소드 선언 시, 매개 변수의 수를 모를 경우
```java
// 매개 변수를 배열 타입으로 선언
int sum1(int[] values) { ... }

int[] values = {1, 2, 3}
int result = sum1(values);
int result = sum1(new int[] {1, 2, 3, 4, 5});

// 매개 변수를 "..."를 사용해서 선언
// - 메소드 호출 시, 배열을 생성 하지 않고, 값만 나열하면 자동으로 배열 생성 됨.
int sum2(int ... values) { }

int result = sum2(1, 2, 3);
int result = sum2(1, 2, 3, 4, 5);
int result = sum2(new int [] {1, 2, 3, 4}); // 배열을 직접 사용 해도 됨
```

### 접근 제한자
...

### 정적 멤버와 static
...

### 패키지
패키지는 클래스를 체계적으로 관리하기 위한 디렉토리 형태의 체계  
- "패키지명+클래스명" 형태로 패키지는 클래스를 유일하게 만드는 역할
- 즉, 클래스 이름이 같아도 패키지 이름이 다르면, 다른 클래스로 인식

#### 패키지 선언
```java
package 상위패키지.하위패키지;
public class ClassName { ... }
```

### 어노테이션(Annotation)
...  


## 05 상속
### Keywoard:
+ 상위 클래스/부모 클래스, 하위 클래스/자식 클래스
+ 코드 중복을 줄이기 위해?
+ `extends`
+ 다중 상속 지원하지 않음

### 클래스 상속
```java
class 자식클래스 extends 부모클래스 {
}

class SportsCar extends Car {
  public SportsCar() {
    super(); // 자식 생성자 호출 시, 부모 생성자 호출 됨.
  }
}
```

### 메소드 재정의(Overriding)
부모 클래스의 특정 메소드를 상황에 따라 자식 클래스에서 **재정의**, 즉 부모 클래스의 메소드를 가림~ 
규칙:
- 부모의 메소드와 동일한 시그너처(리턴 타입, 메소드 이름, 매개변수 리스트)를 가져야 한다.
- 접근 제한을 더 강하게 오버라이딩할 수 없다.
- 새로운 예외를 throws할 수 없다.

@Override 어노테이션 설정 시, 컴파일러가 규칙 체크하여 개발자 실수를 줄여줌.

#### 부모 메소드 호출(super)
자식 클래스에서 오버라이딩된 부모 클래스의 메소드 호출해야 할 때, `super.부모메소드()`로 사용.  

### final 클래스와 final 메소드
`final` 키워드는 클래스, 메소드, 필드에서 사용할 수 있고, 최종상태의 의미를 가짐
+ `final` 클래스는 자식 클래스에서 상속할 수 없는 클래스임
  + `public final class String { ... }`
+ `final` 메소드는 자식 클래스에서 오버라이딩 할수 없음
  + `public final 리턴타입 메소드명() { ... }`
+ `final` 필드는 상수 정의 
  + `public final int success = 0`

### 타입 변환과 다형성
다형성이란 동일한 타입을 사용하지만 다양한 결과가 나오는 성질로써 상속관계에서...
부모 타입에 모든 자식 객체를 대입할 수 있고, 바로 위의 부모가 아니더라도 상속 계층에서 상위 타입이라면 가능하다.

#### 자동 타입 변환  
`부모클래스 변수 = 자식클래스타입;`

#### 필드의 다형성 
부모 타입으로 (자동)형 변환되면, 부모 클래스에 선언된 필드와 메소드만 접근이 가능하다.  
한가지 예외는 자식 클래스에서 메소드가 오버라이딩 되었다면, 자식 클래스의 메소드가 호출 된다.
```java
public class Car {
  Tire tire1 = new KoreaTire(); // 다형성 예
  Tire tire2 = new JapanTire();
}
```

#### 매개 변수의 다형성
```java
public class Car {
  public void run() {} // 차량이 달립니다.
}

public class Bus extends Car {
  public void run() {} // 버스가 달립니다.
}

public class Taxi extends Car {
  public void run() {} // 택시가 달립니다.
}

public class Driver {
  public void drive(Car car) {
    car.run();
  }
}

// main
Taxi taxi = new Taxi()
Driver driver = new Driver(taxi); // Car car = taxi;
driver.run(); // 택시가 달립니다. (자식 객체에서 재정의한 run 호출)
```  

#### 강제 타입 변환(Casting)
자식 객체가 부모 객체의 타입으로 자동 타입 변환 후, 다시 자식 타입으로 변환할 때 강제 타입 변환을 사용할 수 있다.  
어떤 경우에 사용할까? 자식 객체의 필드와 메소드 사용을 하고 싶을 때, 강제 타입 변환 함.
```java
자식 클래스 변수 = (자식 클래스) 부모 클래스 타입;
```

#### 객체 타입 확인(instance of)
강제 타입 변환은 자식 타입이 부모 타입으로 변환된 상태에서만 다시 자식 타입으로 변환 가능하다.
```java
Taxi taxi = (Taxi) car; // car의 타입이 Car인지 Taxi인지 어떻게 알수 있을까?
```

어떤 객체가 어떤 클래스의 인스턴스인지 확인하기 위해서 `instance of` 연산자 사용  
```java
boolean result = 좌항(객체) instanceof 우항(타입)

if (car instanceof Taxi) {
  Taxi taxi = (Taxi) car;
}
```

### 추상 클래스
객체를 직접 생성할 수 있는 클래스를 구현 클래스라고 하면, 해당 클래스의 **공통적인 특성**을 추출하여 선언한 클래스를 추상(abstract) 클래스라고 함.
+ 공통적인 특성은 필드와 메소드
+ 추상 클래스는 `new`연산자를 통해서 객체를 생성할 수 없음

#### 왜? 추상 클래스가 필요할까?
+ 구현 클래스들의 공통된 필드와 메소드 이름의 통일 // user or owner -> user로 통일
+ 구현 클래스 작성 시, 시간절약 - 상속이니... 당연.
+ 추상 클래스는 객체를 생성할 수 없으니... 구현 클래스의 공통된 (설계)**규격***을 정하는 역할  

#### 추상 클래스 선언
클래스 선언 시 `abstract` 키워드 사용
```java
public abstract class Car {
  // 필드
  // 생성자
  // 메소드
}
```

#### 추상 메소드와 오버라이딩
추상 클래스에서 메소드 이름은 통일 시켰는데, 행동이 각 구현 클래스마다 다를 경우, 추상 메소드 사용.  
추상 메소드는 선언부만 있고 실행 내용은 없어서, 자식 클래스에서 반드시 구현을 해야함.  
즉, 추상 메소드는 **구현강제**의 목적.
```java
public abstract class Animal {
  public sbstract void sound(); // {} 없음.
}

public class Dog extends Aniaml {
  @Override
  public void sound() { // 추상 메소드 재정의
    // 멍멍...
  }
}

public class Cat extends Aniaml {
  @Override
  public void sound() { // 추상 메소드 재정의
    // 야옹...
  }
}
```


## 06 인터페이스 (Interface)
역할은? 객체의 사용 방법을 정의, 객체의 사용 설명서
(dark) 상속은 기능의 확장이고, 인터페이스는 기능의 규격화로 볼수 있다.

### 인터페이스 선언
```java
public interface 인터페이스명 {
  // 상수
  [public static final] 타입 상수명 = 10;
  
  // 추상 메소드
  // - 구현 클래스에서 구현 해야 함
  [public abstract] 리턴타입 메소드명(매개변수, ...);
  
  // 디폴트 메소드
  // - 인스턴스 메소드로 구현 객체가 있어야 사용 가능. 
  // - 구현 클래스에서 재정의(Overriding) 가능
  [public] default 리턴타입 메소드명(매개변수, ...) { ... } // 구현가능
  
  // 정적 메소드
  // - 인터페이스로 호출 가능
  [public] static 리턴타입 메소드명(매개변수, ...) { ... } // 구현가능
}
```
[] 부분 생략 시, 컴파일러가 생성 함.

### 인터페이스 구현
#### 구현 클래스
```java
public class 구현클래스명 implements 인터페이스명 {
  // 인터페이스에 선언된 추상 메소드를 구현
}

// TODO: 예시 작성 하자~~~

// 만약 구현 클래스에서 인터페이스의 추상 메소드를 미 구현 시, 추상 클래스로 설정 해야 됨.
public abstract class 구현클래스명 implements 인터페이스명 {
  // 일부만 구현...
}
```

#### 익명 구현 객체
...  


#### 다중 인터페이스 구현 클래스
...  


### 인터페이스 사용
...  

### 타입 변환과 다형성
...  

### 인터페이스 상속
...  

### 디폴트 메소드와 인터페이스 확장
...   


## 07 중첩 클래스와 중첩 인터페이스 (Nested Class and Nested Interface)
중첩 클래스란?  

```java
class ClassName {
  class NestedClassName {}
}
```
+ 클래스안의 클래스 

왜? 사용하니...
+ 두 클래스만 관계가 있을 때, 클래스간 접근이 쉽다.
+ 외부에 불필요한 관계를 숨긴다.?

중첩 클래스 종류는?
+ 멈버 클래스
  + 인스턴스 멤버 클래스: `Class B`
  + 정적 멤버 클래스: `static Calss B`
+ 로컬 클래스: 메소드안에 클래스 정의

### 중첩 클래스와 중첩 인터페이스
... 

### 익명 객체
익명(anonymous) 객체는 이름이 없는객체로써 단독으로 생성할 수 없고
클래스를 생성하거나 인터페이스를 구현해야 한다.  
익명 객체는 **필드**의 초기값이나 **로컬 변수**의 초기값, **메소드 파라미터**로 주로 대입된다.  

그리고, 익명 객체를 로컬 변수로 사용 시, (즉 메소드 내에서 익명 객체 생성) 익명 객체 내부에서 
메소드의 파라미터 값이나 로컬 변수 사용할 경우, 이 변수들은 `final` 특성을 가진다. (즉, 읽기는 가능하나 쓰기는 안됨)

#### 익명 자식 객체 (상속)
```java
부모클래스 [필드|변수] = new 부모클래스(파라미터, ...) {
  // 필드
  // 메소드
}
```
자식 클래스를 재사용하지 않고, 단지 초기값 설정 용도로 사용한다.

#### 익명 구현 객체 (인터페이스)
```java
인터페이스 [필드|변수] = new 인터페이스() {
    // 인터페이스에 선언된 추상 메소드 구현
    // 필드
    // 메소드    
}
```
*Code: No9-anonymous-object*

## 08 예외 처리 (Exception)
...  


## 09 스레드 (Thread)
### 스레드 생성과 실행
#### Runnable 인터페이스의 구현 객체를 통한 스레드 생성과 실행

```java
// (1) Runnable 인터페이스 구현하여 객체 생성
class Task implements Runnable {
    public void run() {
      // 스레드가 실행할 코드
    }
}
Runnable task = new Task();
Thread thread = new Thread(task);

// (2) 또는 익명 구현 객체 생성
Thread thread = new Thread(new Runnable() {
    public void run() {
        // ....
    }
});

thread.start(); // run() 메소드 실행
```
*Runnable 인터페이스의 구현 객체를 만들고, Thread의 생성자로 전달 후, 
Thread 객체에서 `start()` 메소드 호출하면 `run()` 메소드가 실행 된다.*  
```java
Thread thread = new Thread(() -> {
    // 스레드가 실행할 코드
});
```
Runnable 인터페이스는 run() 메소드 하나만 정의되어 있기 때문에 함수적 인터페이스이다. 
그래서 람다 표현식 사용이 가능하다.

#### Thread 클래스 상속을 통한 스레드 생성과 실행
```java
// (1) Thread 클래스 상속하여 객체 생성
public class Task extends Thread() {
    public void run() {
        // ...
    }
}
Thread thread = new Task();

// (2) 또는 익명 (하위) 객체 생성
Thread thread = new Thread(new Thread() {
    public void run() {
        // ...
    }
});

thread.start(); // run() 메소드 실행 
```
*Code: No12-create-thread*

#### 스레드의 이름
```java
thread.setName("스레드 이름");
thread.getName();
```
setName()과 getName()은 Thead 객체의 참조가 필요하다. 
스레드 객체의 참조가 없을 때, 정적 메소드 currentThread()로 현재 스레드의 참조를 얻을 수 있다.
```java
Thread thread = Thread.currentThred();
```

#### 스레드 Priority 설정
```java
thread.setPriority(우선순위);

// Constant 
thread.setPriority(Thread.MAX_PRIORITY); // 10
thread.setPriority(Thread.NORM_PRIORITY); // 5 
thread.setPriority(Thread.MIN_PRIORITY); // 5 
```
우선순위는 1 ~ 10이고, 10이 가장 높다.  

### 임계 영역(Critical Section) 설정 방법
자바에서 임계 영역 설정을 위해서 동기화(synchronized) 메소드와 동기화 블록을 제공한다.
```java
// 동기화 메소드 설정
public synchronized void increment() {
    // 임계 영역 - 단 하나의 스레드만 실행
}

// 동기화 블록 설정
public void increment() {
    // 여러 스레드 실행 가능
    synchronized(공유객체) { // 공유 객체가 객체 자신이면 this을 넣을수 있다.
        // 임계 영역 - 단 하나의 스레드만 실행 
    }
    // 여러 스레드 실행 가능
}
```
메소드 선언에 `synchronized` 키워드 설정 시, 메소드 전체가 임계 영역이 되고, 
일부 내용만 임계 영역으로 만들고 싶으면 동기화(synchronized) 블록을 만들되면 돤다.


### ref
+ https://codechacha.com/ko/java-atomic-types/

## 10 제너릭 (Generic)
제네릭(Generic) 은 클래스, 인터페이스, 메서드등의 **타입**을 **파라미터로** 사용할 수 있게 해주는 역할을 한다.
...  


## 11 자바 API (library)

### java.lang  

### java.util  

### java.time  


## 12 I/O 입출력
...  


## 13 자바 네트워킹
...


## Reference 
> + ...   

[^1]: https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
[^2]: https://stackoverflow.com/questions/2885385/what-is-the-difference-between-an-instance-and-an-object