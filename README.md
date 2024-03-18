# 게시판 설명문서

## 1. 개요
이 문서는 게시판 프로젝트의 구조와 기능을 설명합니다. 이 프로젝트는 사용자 관리, 간단한 회계 내역 기능을 제공하는 웹 애플리케이션입니다.

## 2. 데이터베이스 설계
- **JSP_MEMBER 테이블**: 사용자 정보를 저장합니다. (`ID`, `PASSWORD`, `NAME`, `TEL`, `EMAIL`,'GRANTED')
- **JSP_ACCOUNTING 테이블**: 입금 및 출금 내역을 저장합니다. (`SEQ`, `REGDATE`, `CATEGORY`, `MONEY`, `NOTE`)
- **GETPASS 테이블**: 비밀번호를 찾을때 필요한 임시 ID 및 인증번호를 저장합니다. (`ID`, `TEMP_PASS`)

## 3. 주요 기능
### 3.1 사용자 관리
- **사용자 등록**: 새로운 사용자를 등록할 수 있습니다.
- **로그인**: 사용자 이름과 비밀번호를 통해 로그인할 수 있습니다.
- **아이디 중복 체크**: 사용자 이름의 중복 여부를 확인할 수 있습니다.
- **비밀번호 찾기**: 이메일을 통해 사용자의 비밀번호를 찾을 수 있습니다.

### 3.2 내역관리
- **입출금 내역 전체 조회**: 입출금 내역을 조회할 수 있습니다.
- **입출금 등록**: admin계정으로 새로운 입출금 내역 등록 가능합니다
- **입출금 수정**: admin계정으로 기존에 기입된 입출금 내역을 수정 가능합니다.
- **입출금 삭제**: admin계정으로 기입된 입출금 내역 삭제 가능합니다.
- **입출금 검색**: 날짜를 지정해서 조회해 특정기간동안 삽입된 내역의 조회가 가능합니다

## 4. 화면 구성
### 4.1 메인 페이지 (`login.jsp`)
- 로그인 버튼
- 회원가입 버튼
- 비밀번호 찾기

### 4.2 비밀번호 찾기 페이지 ('searchPass.jsp','searchPass2.jsp','CheckPassCtrl2.java','CheckPassCtrl2.java')

### 4.2 회원가입 페이지 (`createAccount.jsp`)
- 회원가입 가능
- 아이디 중복체크 -> CreateMemberCtrl.java 에서 중복 확인

### 4.4 메인 페이지 (`accountMain.jsp`, `MainAccountCtrl.java')
- 최근 기입순으로 전체조회
- 간편수정 및 삭제
- 날짜로 특정 기간으로 조회

### 4.5 날짜 조회 페이지 (`accountQuery.jsp','AccountQueryCtrl.java`)
- 특정 기간 입금 내역 및 출금내역 조회
- 총 입금 금액 및 출금금액 출력
- 각 내역 상세보기

### 4.6 상세 내역 페이지 (`accounDetail.jsp`,'AccountDetailCtrl.java','AccountUpdateCtrl.java')
- 기입 내역 수정 가능


## 5. 사용된 라이브러리 및 기술
- Java 8
- Dynamic Web Project 4.0
- Oracle Database
- Bootstrap 3.3.2
- activation 1.1.1
- mail 1.4.7
- Jquery

## 6. 프로젝트 구조
- `account.control`: 입출금 관리 비즈니스 로직이에 필요한 서블릿 파일이 위치합니다.
- `biz.dao`: 입출금 내역 및 계정의 데이터베이스 연동 및 비즈니스 로직에 필요한 서블릿 파일이 위치합니다.
- `biz.vo`: dto로 사용될 클래스가 존재합니다.
- `member.control`: 계정생성 및 로그인처리, 비밀번호 찾기등의 필요한 서블릿 파일이 위치합니다.
- `src/main/webapp/WEB-INF/views`: JSP 파일이 위치합니다.
- `src/main/webapp/resources`: CSS, JavaScript, 이미지 등의 정적 리소스 파일이 위치합니다.

## 7. 주요 흐름
### 7.1 사용자 등록 및 로그인
- 회원가입 페이지에서 사용자 정보를 입력하고 등록합니다.
- 아이디 중복확인이 가능합니다.
- 로그인 페이지에서 등록된 사용자 정보로 로그인합니다.
- 로그인 성공 시 세션에 사용자 정보를 저장하고, 게시글 목록 페이지로 이동합니다.

### 7.2 게시글 등록 및 조회
- 로그인한 사용자는 입출금 내역 확인이 가능합니다.
- admin 유저는 내역의 등록,수정 및 삭제가 가능합니다.
- 상세보기 페이지에서 등록된 내역을 확인할 수 있습니다.