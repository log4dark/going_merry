# Java
Drop in Java

## Start...
API Document link: <https://docs.oracle.com/javase/8/docs/api/>
### 자바란?
- 객체지향 언어
- Garbage Collector
- JVM(Java Virtual Machine) - One source multi-use
- 함수적 스타일 코딩 지원 -> 람다식(Lambda Expression)

 
## Data Type
### 기본 타입(Primitive Type)
#### 정수 타입
- byte: 1byte - 바이너리 데이터 처리할 때 사용 (파일, 네트워크)
- char: 2byte, 0~2^16-1, (유니코드: \u0000~\uFFFF)
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
```
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
```
int[] array; // 타입[] 변수
int array[]; // 타입 변수[]
```
배열 선언과 값 할당
```
String[] name1 = {"dark", "penny", "jisung");
String[] name2 = null;
name2 = new String[] {"dark", "penny", "jisung");
// 배열 객체의 주소 출력
System.out.printf("name=%x\n", System.identityHashCode(name));
```
커맨드 라인 입력
```
// $ java TcpServer 127.0.0.1 20000 
public String void main(String[] args) {
	args.length; // 2
    args[0]; // 127.0.0.1
    args[1]; // 20000 
    ...
}
```
다차원 배열
```
int[][] scores = new int[2][3];
scores.length; // 2
scores[0].length; // 3
scores[1].length; // 3
```
#### Enum 타입
Enum 선언
```
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
```
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
C/C++ style Enum
- ref: https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
```
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
```
for ( (2)타입 변수 : (1)배열 ) {
	(3)실행문;
}

int[]scores = {95, 90, 87, 89, 97};
for (int scores : scores) {
	// processing...
}
```

## Class
### 객체지향 프로그래밍
객체간의 상호작용, 메소드 호출(메시지 전달), 객체간의 관계.  

#### 객체란?
물리적으로 존재하거나 추상적으로 존재하며 자신만의 속성을 가지고 식별되는 개체이다.  
객체는 속성과 동작으로 구성되어 있고, 자바에서는 각각을 필드(**field**)와 메소드(**method**)라고 한다.

**Instance vs. Object**  
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

### 클래스의 구성 멤버


### 접근 제한자


### 정적 멤버와 static


## 패키지


## 어노테이션(Annotation)


## 상속
...  


## 인터페이스
...  


## 예외 처리
...  

## Basic API Class
...  


## 제너릭
...  


## 컬렉션
...  

