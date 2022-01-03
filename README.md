# :pushpin: QPMS
>웹 기반 프로젝트 관리 시스템 <br>
>프로젝트를 진행하며 체계적인 관리의 필요성을 느껴 '프로젝트 관리 시스템' 제작을 진행하였습니다. <br>
> - Dashboard와 Gantt Chart를 통해 프로젝트 통계, 프로젝트 Task를 파악하기 쉽습니다.
> - 전자결재 프로세스를 통해 완료한 Task를 보고합니다.
> - 대화방을 생성하고 원하는 사용자를 초대하여 채팅할 수 있습니다.
> 
>www.qpms.co.kr <br>
>
>테스트 계정
> - 관리자 권한: hi2 / hihi
> - 실무자 권한: hi10 / hihi

</br>

## 1. 제작 기간 & 참여 인원
- 2021년 09월 01일 ~ 10월 25일
- 팀 프로젝트 (3인)

</br>

## 2. 사용 기술
  - Java 11
  - Spring Boot 2.5
  - Spring Security
  - Thymeleaf
  - MariaDB
  - Gradle
  - SMTP 메일 전송을 통한 회원가입
  - WebSocket 기반 채팅
  - Gantt Chart, Chart.js, Full Calendar를 활용한 프로젝트, 작업, 일정 통합 관리
  - AWS 활용 배포

</br>

## 3. ERD 설계
프로젝트, 회원, 작업, 커뮤니티, 리스크, 스케줄 등에 대해 ERD를 설계하였습니다.

<details>
<summary><b>ERD 설계 펼치기</b></summary>
<div markdown="1">

### 3.1. 전체 ERD 요약
![](https://github.com/chaewon-dev/portfolio/blob/main/src/ERD_summary.png)

### 3.2. 전체 ERD 
![](https://github.com/chaewon-dev/portfolio/blob/main/src/ERD_all.png)

### 3.3. ERD 확대 ver.
![](https://github.com/chaewon-dev/portfolio/blob/main/src/ERD_detail_01.png)
![](https://github.com/chaewon-dev/portfolio/blob/main/src/ERD_detail_02.png)
  
</div>
</details>

</br>
