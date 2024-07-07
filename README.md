### 1. 프로젝트 소개
#### 1.1. 개발배경 및 필요성
● 최근 몇 년간 장기 결제를 통해 고객을 유치하는 업계에서 '먹튀' 사건이 빈번하게 발생(필라테스/헬스장 및 체육 시설, 인터넷 강의를 제공하는 사이트 등) 경영상 어려움을 이유로 돌연 폐업을 결정한 뒤, 수강료를 돌려주지 않는 이러한 사건들은 피해자들에게 금전적 손실을 안기고 관련업종의 신뢰도를 저하함.

● 한국소비자원에 따르면 헬스장 피해구제 건수는 2021년부터 꾸준히 우상향,작년 피해 건수는 3,165건으로 재작년에 비해 19% 상승
> ![image](https://github.com/pnusw-hackathon/PNUSW-2024-team-14/assets/173755717/40fd9eda-3916-40f5-9758-faab1575d69a)

● 법적 구제 수단이 약해 피해보상을 받기도 어려음. 현행 법률에서는 
  - 피해자들이 직접 민사 소송을 제기하거나 
  - 소비자원에 피해구제를 요청해야 함. 이 과정은 시간과 비용이 많이 들 뿐 아니라 절차가 복잡해 실효성이 떨어짐.
  - 형사적 처벌 즉, 사기죄로 고소할 수 있으나 사업주가 회원을 모집하는 처음부터 폐업을 계획하고 금전적 이익을 취할 의도가 있었음을 증명해야 처벌할 수 있음.이 또한 피해자들이 증명하기 힘들기에 처벌이 어려움

● 현재 다음과 같은 법안이 각각 발의됐지만, 현재까지도 상임위 계류 중이며 실현되고 있지 않음. 
  - 3개월 이상 선불 이용료를 받는 체육시설이 보증보험에 의무적으로 가입하도록 하는 법안(이상헌 더불어민주당 의원 대표 발의), 
  - 체육시설이 폐업할 경우 그 사실을 폐업 14일 전까지 소비자에게 알리도록 의무화하는 법안(김영배 민주당 의원 대표 발의)

● 이러한 사건이 빈번히 일어나는 핵심 이유는 사전영업(프리세일)임.운동 기구와 인테리어 등 헬스장 시설을 완비하기 전에 회원권부터 판매하는 관행으로, 먼저 마련한 돈으로 뒤늦게 운동 기구를 들여오고, 인테리어 공사도 마치는 방법. 이는 무자본으로 헬스장을 창업하면서 갖가지 사업 리스크를 소비자들에게 떠넘기고 있는 셈.

● 일반적인 소비자 입장에서는 이 업장이 언제 갑작스레 폐업할지, 혹은 안정적인 자본으로 차린 헬스장이 맞는지 알기 힘듦. 대부분의 업장에서는 장기 결제를 유도하기 위해 다양한 할인 행사를 제공하고, 소비자들은 의심 없이 결제함. 피해자가 사기 사실을 알게 되었을 때 카드 항변권을 통해 남은 할부 금액을 카드사로부터 받을 수 있는 경우도 있지만 많은 과정을 거쳐야함. 만약 손해배상 청구 후 강제 집행을 하더라도 피해자가 많아 개인이 받는 보상 금액은 적을 수밖에 없음.


#### 1.2. 개발 목표 및 주요 내용
● 개발목표

> 피트니스 업계의 장기 정액권에 가입하거나, 할부 결제를 통해 등록한 고객들이 업장의 사업 종료로 인해 결제 대금을 돌려받지 못하는 상황을 위한 대책 마련

● 주요내용

> 기존의 헬스장 결제 시스템에서는 소비자가 직접 헬스장에 결제 대금을 지불함. 	헬스장이 도중에 폐업하게 되면 소비자는 이미 지불한 금액을 돌려받기 어렵기에 큰 경제적 손실을 입음. 또한 소송을 한다 하더라도 많은 비용과 시간이 들기에 실질적인 보상을 받기 어려움.
이를 해결하기 위해 소비자와 헬스장 사이에서 결제 대금을 관리하고, 헬스장이 폐업했을 때 소비자가 지는 리스크를 최소화하는 어플리케이션을 제공함.


#### 1.3. 세부내용
●  검색 및 정보 제공 서비스
->소비자가 편하게 정보를 제공받도록 하고, 접근성을 늘이기 위한 기능

 ● 어플에서 제공하는 검색 시스템은 일반적인 통합 검색 시스템을 내용으로 함.
 
 ● 소비자 검색을 통해 특정 헬스장의 상세 정보, 가격, 위치 그리고 후기 등의 정보 제공
 
 ● 추천순, 거리순, 평점순의 여러 필터를 사용하여 검색, 관련 헬스장의 정보 제공
 
 ● 지도를 통한 검색 기능
  -> 어플 사용자의 현재 위치 기반으로 주변 헬스장을 핀 형식으로 제공 / 핀을 통해 상세 정보 화면 확인

● 결제 시스템
기존의 소비자가 리스크를 가지게 되는 결제 방식에서 안전을 보장해주는 어플의 대표 기능. 
문제 발생 시, 결제 내역에 대해 환불, 결제 대금 보존 등의 방식으로 소비자의 피해 최소화

1) 일시불 결제로 진행
- 기존 방식
> ![image](https://github.com/pnusw-hackathon/PNUSW-2024-team-14/assets/173755717/85e0ecf1-b2b4-4e47-aa2b-daada1442873)
● 소비자가 헬스장에 전액 결제
● 헬스장이 도중에 폐업하면 환불 불가

- 어플 활용 방식
> ![image](https://github.com/pnusw-hackathon/PNUSW-2024-team-14/assets/173755717/9acb182b-8dd3-4f6f-afa5-37567c96a66b)
● 소비자가 앱에 결제 대금을 지불
● 앱이 매월 헬스장에 분할 납부
● 헬스장이 도중에 폐업할 경우, 남은 금액을 소비자에게 환불

활용 예시
● 소비자가 12개월 정액권을 120만원 일시불로 결제
● 기존 방식 : 헬스장이 3개월 후 폐업하면 환불 불가
● 어플 활용 : 앱이 매월 10만원씩 헬스장에 납부, 3개월 후 폐업 시 남은 90만원을 환불

1) 할부 결제로 진행
- 기존 방식
> ![image](https://github.com/pnusw-hackathon/PNUSW-2024-team-14/assets/173755717/e34a93be-15be-438f-99a9-80d68c7206dd)
● 소비자 → 카드사 → 헬스장
● 카드사가 즉시 전액을 헬스장에 납부, 소비자는 카드사에 매월 할부금 지급
● 헬스장이 폐업하면 소비자는 할부금 지급을 멈추기 위한 항변권을 행사하기 어려움 (까다로운 조건)

- 어플 활용 방식
> ![image](https://github.com/pnusw-hackathon/PNUSW-2024-team-14/assets/173755717/bc6ff2b7-4ad6-4752-8cf8-f07fdd1d9e59)
● 소비자 → 카드사 → 어플 → 헬스장
● 카드사가 대금을 어플에 납부, 어플이 헬스장에 분할 납부
● 헬스장이 폐업하면 소비자는 남은 할부금을 카드사에 지불하고 어플은 남은 금액을 환불

활용 예시
● 소비자가 3개월 정액권을 90만원 할부로 결제
● 기존 방식 : 소비자가 카드사를 통해 3개월 할부 신청 → 카드사가 즉시 90만원을 헬스장에 납부 → 소비자는 3개월간 30만원씩 카드사에 지급 → 헬스장이 2개월 후 폐업했다해도 남은 할부금 환불 불가
● 어플 활용 : 소비자가 카드사를 통해 3개월 할부 신청 → 카드사가 앱에 90만원 납부 → 앱이 매월 10만원씩 헬스장에 납부 → 2개월 후 폐업했다면 소비자는 우선 카드사에 남은 할부금을 내지만 이후 어플을 통해 70만원을 환불.

●  홍보 시스템
> 사업주의 경우, 소비자나 카드사를 통해 한 번에 목돈처럼 받던 영업이익을 분할로 받아야 하므로 앱의 이용이 꺼려짐. 따라서 앱을 결제 대행과 동시에 업체의 홍보 창구로 활용함으로써 업체가 수익을 분할로 납부받는 것에 대한 단점을 상쇄. 
> 앱의 장기적인 활용을 위해 사용 업체를 홍보하는 일종의 커뮤니티 역할로 기능, 홍보 게시판이나 배너를 통해 우리 지역의 ‘어플 사용 업체’를 적극적으로 홍보함으로써 앱을 사용하기 전에는 없었을 영업이익을 끌어올 것.

#### 1.4. 기존 서비스 대비 차별성
> 위 내용을 작성하세요.

#### 1.5. 사회적가치 도입 계획
> 위 내용을 작성하세요.


### 2. 상세설계
#### 2.1. 시스템 구성도
> 시스템 구성도(infra, front, back등의 node 간의 관계)의 사진을 삽입하세요.

#### 2.1. 사용 기술
> 스택 별(backend, frontend, designer등) 사용한 기술 및 버전을 작성하세요.
> 
> ex) React.Js - React14, Node.js - v20.0.2

### 3. 개발결과
#### 3.1. 전체시스템 흐름도
> 위 내용을 작성하세요.

#### 3.2. 기능설명
> 각 페이지 마다 사용자의 입력의 종류와 입력에 따른 결과 설명 및 시연 영상.
> 
> ex. 로그인 페이지:
> 
> - 이메일 주소와 비밀번호를 입력하면 입력창에서 유효성 검사가 진행됩니다.
> 
> - 요효성 검사를 통과하지 못한 경우, 각 경고 문구가 입력창 하단에 표시됩니다.
>   
> - 유효성 검사를 통과한 경우, 로그인 버튼이 활성화 됩니다.
>   
> - 로그인 버튼을 클릭 시, 입력한 이메일 주소와 비밀번호에 대한 계정이 있는지 확인합니다.
>   
> - 계정이 없는 경우, 경고문구가 나타납니다.
>
> (영상)

#### 3.3. 기능명세서
> 개발한 제품에 대한 기능명세서를 작성해 제출하세요.
> 
> 노션 링크, 한글 문서, pdf 파일, 구글 스프레드 시트 등...

#### 3.4. 디렉토리 구조
> 위 레포지토리의 디렉토리 구조를 설명하세요.

### 4. 설치 및 사용 방법
> 제품을 설치하기 위헤 필요한 소프트웨어 및 설치 방법을 작성하세요.
>
> 제품을 설치하고 난 후, 실행 할 수 있는 방법을 작성하세요.

### 5. 소개 및 시연 영상
> 프로젝트에 대한 소개와 시연 영상을 넣으세요.
> 프로젝트 소개 동영상을 교육원 메일(swedu@pusan.ac.kr)로 제출 이후 센터에서 부여받은 youtube URL주소를 넣으세요.

### 6. 팀 소개
> 팀원 소개 & 구성원 별 역할 분담 & 간단한 연락처를 작성하세요.

### 7. 해커톤 참여 후기
> 팀원 별 해커톤 참여 후기를 작성하세요.
