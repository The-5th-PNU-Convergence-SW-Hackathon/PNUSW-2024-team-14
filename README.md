## 1. 프로젝트 소개
### 1.1. 개발배경 및 필요성
### 가. 개발목표
#### I. 나날이 늘어가는 폐업 '먹튀' 사기 피해
> 최근 몇 년간 장기 결제를 통해 고객을 유치하는 업계에서 <strong>'먹튀'</strong> 사건이 빈번하게 발생(필라테스/헬스장 및 체육 시설, 인터넷 강의를 제공하는 사이트 등) <br/>
>  경영상 어려움을 이유로 돌연 폐업을 결정한 뒤, 수강료를 돌려주지 않는 이러한 사건들은 피해자들에게 금전적 손실을 안기고 관련업종의 신뢰도를 저하함.

> 한국소비자원에 따르면 헬스장 피해구제 건수는 2021년부터 꾸준히 우상향,작년 피해 건수는 3,165건으로 재작년에 비해 19% 상승 <br/><br/>
 <img src = "https://github.com/pnusw-hackathon/PNUSW-2024-team-14/assets/173755717/40fd9eda-3916-40f5-9758-faab1575d69a" width = "220">

#### II. 까다로운 피해보상 과정 <br/>
> 법적 구제 수단이 약해 피해보상을 받기도 어려움. 현행 법률에서는 <br/>
    - 피해자들이 직접 민사 소송을 제기하거나<br/>
    - 소비자원에 피해구제를 요청해야 함.<br/>
    이 과정은 시간과 비용이 많이 들 뿐 아니라 절차가 복잡해 실효성이 떨어짐.<br/>
    - 형사적 처벌 즉, 사기죄로 고소할 수 있으나 사업주가 회원을 모집하는 처음부터 폐업을 계획하고 금전적 이익을 취할 의도가 있었음을 증명해야 처벌할 수 있음. 이 또한 피해자들이 증명하기 힘들기에 처벌이 어려움<br/>

#### III. 진전 없는 해결방식  <br/>
> 현재 다음과 같은 법안이 각각 발의됐지만, 현재까지도 상임위 계류 중이며 실현되고 있지 않음.<br/>
    - 3개월 이상 선불 이용료를 받는 체육시설이 보증보험에 의무적으로 가입하도록 하는 법안(이상헌 더불어민주당 의원 대표 발의)<br/>
    - 체육시설이 폐업할 경우 그 사실을 폐업 14일 전까지 소비자에게 알리도록 의무화하는 법안(김영배 민주당 의원 대표 발의)<br/>
<br/>

### 나. 개발필요성 <br/>
#### I. 깊게 뿌리내린 관행 - 사전영업
> 이러한 사건이 빈번히 일어나는 핵심 이유는 사전영업(프리세일)임.<br/>
> 운동 기구와 인테리어 등 헬스장 시설을 완비하기 전에 회원권부터 판매하는 관행으로, 먼저 마련한 돈으로 뒤늦게 운동 기구를 들여오고, 인테리어 공사도 마치는 방법. 이는 무자본으로 헬스장을 창업하면서 갖가지 사업 리스크를 소비자들에게 떠넘기고 있는 셈.
> <br/>

#### II. 소비자의 불안과 불확실성
> 일반적인 소비자 입장에서는 이 업장이 언제 갑작스레 폐업할지, 혹은 안정적인 자본으로 차린 헬스장이 맞는지 알기 힘듦.<br/>
> 대부분의 업장에서는 장기 결제를 유도하기 위해 다양한 할인 행사를 제공하고, 소비자들은 의심 없이 결제함. 피해자가 사기 사실을 알게 되었을 때 카드 항변권을 통해 남은 할부 금액을 카드사로부터 받을 수 있는 경우도 있지만 많은 과정을 거쳐야함. 만약 손해배상 청구 후 강제 집행을 하더라도 피해자가 많아 개인이 받는 보상 금액은 적을 수밖에 없음.
<br/>

### 다. 해결방안 
현재의 문제 상황은 다음과 같이 요약할 수 있음 </br> 
> 장기 회원권을 구매한 소비자들이 업장의 갑작스러운 폐업으로 결제 대금을 환불받지 못하는 피해를 입고 있음.

이를 해결하기 위해 우리는 기존의 B2C 방식의 결제 시스템을 개선하고자 함.</br>
블록체인을 활용하여 소비자와 헬스장 간의 결제 과정에 <strong>대금 환불을 보장하는 스마트 컨트랙트</strong>를 도입하고, 법적 보호를 받지 못하는 피해자가 발생하지 않도록 함.</br>
이 시스템을 통해 소비자는 보다 안전하게 서비스를 이용할 수 있고, 불안정한 사업 종료로 인한 경제적 피해를 최소화할 것. <br/><br/>


### 1.2. 개발 목표 및 주요 내용
### 가. 개발목표
피트니스 업계의 장기 정액권에 가입한 고객들이 업장의 갑작스러운 사업 종료에도 남은 대금을 환불 받을 수 있는 안심 결제 어플리케이션 <br/>

### 나. 주요내용 <br/>
#### I. 스마트 컨트랙트 서비스
- <b>스마트 컨트랙트를 통한 안전한 결제 보증</b> </br>
> 소비자가 헬스장 회원권을 구매한 대금은  앱에서 설계한 독자적인 스마트 컨트랙트에 잠금 상태로 보관됨.</br> 헬스장이 정상적으로 운영되고 계약 조건이 충족될 때 소비자 회원권의 개월 수에 맞추어 매월 말일에 대금을 분할지급.</br> 만약 헬스장이 폐업하거나 계약 조건을 위반할 경우, 스마트 컨트랙트에 의해 자동으로 소비자에게 환불됨.
- <b>투명한 거래 기록</b> </br>
> 블록체인 기술을 통해 모든 거래 기록은 투명하게 공개. 이를 통해 운영의 투명성을 높이고, 소비자들이 안심하고 결제할 수 있는 환경을 조성
- <b>비용 효율적인 피해 구제 절차</b> </br>
> 기존의 복잡하고 비용이 많이 드는 법적 구제 절차와 달리, 스마트 컨트랙트는 자동으로 계약 이행을 관리하고, 문제가 발생할 경우 즉시 환불 절차를 시작.
- <b>고정가치로 발행되는 USDT(테더) 활용</b> </br>
> 대금을 보관한 후에 코인 가격의 급격한 변동으로 업체가 받아야 할 대금의 가격이 달라지면 안됨. 변동성을 줄이기 위해 스테이블 코인 활용

</br>

#### I-1. 결제시스템 흐름도

 - <b> 기존 방식</b><br/>
 ![image](https://github.com/pnusw-hackathon/PNUSW-2024-team-14/assets/173755717/85e0ecf1-b2b4-4e47-aa2b-daada1442873)
 
 > 소비자가 헬스장에 전액 결제<br/>
 > 헬스장이 도중에 폐업하면 환불 불가<br/>

 <br/>
 
 - <b> 어플 활용 방식</b><br/>
 ![image](https://github.com/pnusw-hackathon/PNUSW-2024-team-14/assets/173755717/9acb182b-8dd3-4f6f-afa5-37567c96a66b)
 
 > 소비자가 앱에 결제 대금을 지불<br/>
 > 스마트 컨트랙트에 보관된 대금이 매월 헬스장에 분할 납부<br/>
 > 헬스장이 도중에 폐업할 경우, 자동적으로 남은 금액을 소비자에게 환불




<br/>
 
 #### I-2. 멀티 시그 (Multi-Signiture)
 스마트 컨트랙트에서 <b>권한을 가진 주체 과반의 승인이 있어야만 거래가 실행되는 시스템</b></br>
 > 어플이 아닌 스마트 컨트랙트 자체에서 소비자의 대금을 보관하지만, 소비자 입장에서는 우리 어플이 스마트 컨트랙트 주소에 접근해서 소비자의 대금을 다른 사용처에 사용할 수 있다는 불안감이 존재할 수 있음. </br>
 > 이에 헬스장의 계좌가 아닌 다른 계좌로 자금을 옮길 경우, <b>3자(신뢰기관인 은행, 소비자, 어플) 중 최소 2자의 승인</b>이 필요하도록 설정 </br>
 - <b>환불</b> </br>
   소비자 + 앱의 빠른 승인으로 소비자 계좌로 신속히 환불
 
 - <b>비정상적 자금 이동 방지</b> </br>
   계약을 배포한 어플마저도 독단으로 자금을 인출하지 못함. 은행이나 소비자의 추가 승인이 필요한 신뢰 시스템을 구축

 <img src = "https://github.com/user-attachments/assets/4d7de904-0740-43a7-a9e2-077c84e5095d" width = "200">

   </br>

#### II. 전자 계좌(Wallet) 생성 서비스
스마트 컨트랙트를 진행하기 위해서는 wallet이 필요함. 암호화폐를 주고 받는 스마트 컨트랙트의 거래 방식이 일반적인 사용자에게 생소하게 느껴질 수 있음 </br>
사용자가 쉽게 전자 계좌를 생성하고 등록할 수 있는 <b>사용자 친화적인 서비스</b> 제공.

   </br>

#### III. 업체 홍보 관리 서비스
> 사업주의 경우, 소비자나 카드사를 통해 한 번에 목돈처럼 받던 영업이익을 분할로 받아야 하므로 앱의 이용이 꺼려짐 우려. <br/>따라서 앱을 결제 대행과 동시에 업체의 홍보 창구로 활용함으로써 업체가 수익을 분할로 납부받는 것에 대한 단점을 상쇄.<br/>
앱의 장기적인 활용을 위해 사용 업체를 홍보하는 일종의 커뮤니티 역할로 기능, 홍보 게시판이나 배너를 통해 우리 지역의 ‘신뢰 업체’임을 적극적으로 홍보하여 앱을 사용하기 전에는 없었을 영업이익을 끌어올 것.

메인 배너 / 스크롤 페이지에서 업체들을 보여줌. 소비자는 온라인으로 회원권을 구매할 수 있음. 

   </br>

#### IV. 신고 및 환불 서비스
> 업체의 이상 유무를 가장 빨리 확인할 수 있는 사람은 실 사용 소비자. 소비자 신고가 들어오면 업체 영업여부를 확인. </br> 신고일을 기준으로 지불하야하는 대금을 계산하여 업체 계좌에 마저 납부하고 중지.

최초 신고 이후 신고 헬스장의 회원권을 지닌 모든 소비자에게 팝업 알림 전송. </br>
이어지는 환불 절차 페이지를 통해 날짜와 금액을 안내하고, <b>환불을 위한 멀티시그 승인허가</b> 요청. </br>
앱 + 소비자의 승인으로 남은 대금을 소비자 계좌에 신속히 환불

   </br>

### 1.3. 세부내용
### 가. 기능 요구사항

#### I. 결제 서비스
|기능|설명|
|:---:|:---:|
|전자 계좌 생성|스마트 컨트랙트를 실행시키기 위한 전자 계좌를 받는다|
|전자 계좌 등록|기존에 가지고 있던 전자 계좌를 등록하거나 발급받은 계좌를 계정에 등록한다|
|회원권 구매|회원권 기간과 금액을 정하여 구매한다|

#### II. 환불 서비스
|기능|설명|
|:---:|:---:|
|환불 알림|폐업이 확인된 헬스장의 회원일 경우 환불 안내를 알림으로 받는다|
|환불 내역 안내|폐업 헬스장, 폐업 날짜, 환불 금액, 환불 정책을 안내 받는다|
|환불 승인 요청|환불 내역 안내 이후 멀티시그 승인을 위한 환불 승인 요청을 받는다|

#### III. 홍보 
|기능|설명|
|:---:|:---:|
|등록 헬스장 목록 보기|어플에 등록된 헬스장 목록을 볼 수 있다|
|등록 헬스장 상세 보기|헬스장의 주소, 별점, 회원권 금액 등을 볼 수 있다|
|등록 헬스장 검색|등록 헬스장을 연관 이름으로 검색할 수 있다|
|지도 검색 기능|내 주변 등록 헬스장을 핀 형식으로 확인 할 수 있다|

#### IV. 마이페이지 
|기능|설명|
|:---:|:---:|
|소비자 신고 접수|폐업 의심 업장을 신고 접수 할 수 있다|
|전자계좌 잔액 확인|내 전자계좌에 남은 잔액을 확인할 수 있다|
|결제 내역 확인|결제 내역과 남은 회원권 기간을 확인할 수 있다|

</br>

### 나. 사용자 요구사항
|요구사항|설명|
|:---:|:---:|
|간편한 절차|대부분의 소비자가 생소한 전자 거래를 간단하게 제공해야한다|
|신뢰 환경 제공|앱의 독단적인 출금 시도, 재정난에도 사용자의 대금은 관계없이 보관되야한다| 

</br>

#### 1.4. 기존 서비스 대비 차별성
- Google Playstore 기준, 피트니스 및 헬스 부문 인기 어플 상위 50개의 서비스 제공은 헬스케어, 헬스장 가격 비교, 운동 루틴 추천 등에 그침.<br/>

|이름|헬스장 홍보|가격비교|온라인 결제|통합 회원권|안심 결제|폐업 업체 대응|
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
|페이퍼|o|o|o||o|o|
|다짐|o|o|o|o||
|니짐내짐|o|o|o|||

- 폐업 사기로 인해 발생하는 피해 1위인 업계에서 소비자가 안심하고 결제할 수 있는 시스템이 마련되어 있지 않음. 페이퍼(pay per)는 <b>독자적인 결제 방식</b>을 통해 업체의 폐업으로 소비자에게 발생하는 문제를 최소화
함. </br> 
- 온라인 거래에서 거래의 안정성을 보장하기 위해 제 3자가 중재하는 ‘에스크로’ 방식 존재.</br>
주로 크림, 네이버 안전 결제 등이 대표적으로 사용하는 서비스인데, 제 3자가 대금을 보관하다가 거래 완료 시, 대금을 정산하는 방식. </br> 하지만 한 번에 대금과 서비스를 거래하는 경우에만 가능하기 때문에, 장기적인 서비스를 제공해야 하는 경우는 활용이 어렵다는 점에서 ’페이퍼(patper)’와 차별점이 존재. 
</br>

### 1.5. 사회적가치 도입 계획
#### I. 헬스장 피해 인원 대폭 감소 
> 앱을 활용할 경우 소비자의 피해 리스크를 최소한으로 줄이며, 부실 업체의 장기 대금을 통한 사기 피해를 대부분 막을 수 있음. 현재까지도 피해자가 증가하고 있는 사회 문제이지만, 서비스의 대중화가 이루어진다면 이러한 문제로 인해 발생하는 피해자는 급감할 것
#### II. 건강한 구조의 피트니스 문화 
> 폐업 피해 인원을 줄이고, 소비자가 업장의 사정과 관계없이 반드시 환불 받을 수 있는 수단을 마련. 사전영업이 성행하는 기존의 피트니스 창업 문화에 긍정적인 영향을 줄 것. 
#### III. 다른 사업 분야 
> 현재 구체적으로 계획 중인 분야는 헬스장을 비롯한 체육시설이지만, 이러한 갑작스러운 사업 종료로 인해 소비자가 경제적 손해를 볼 가능성이 있는 다양한 업종이 존재.
- 소비자원에 접수된 의료 서비스 분야 소비자 분쟁 사건(1,125건)에서 업장의 폐업으로 인한 선납 진료비사건이 약 38%
- 인터넷 강의 사이트나 학원 등 연간 회원권을 판매하는 업체에서도 꾸준히 업체의 갑작스러운 사업 종료로 피해를 보는 소비자들이 보고됨.
> 페이퍼의 핵심은 스마트 컨트랙트 기반의 독자적인 결제 시스템에 있기 때문애 어플의 기반에 큰 변화없이 다양한 사업 분야에 활용할 수 있음. 이는 다양한 분야의 소비자 구제를 위한 새로운 해결책이 될 것. 


## 2. 상세설계
### 2.1. 시스템 구성도
#### I. Architecture Diagram
<img src = "https://github.com/user-attachments/assets/2ef98ad3-95dc-4f20-8d16-8ff9b68ffc33" width = "400">

#### II. ERD
<img src = "https://github.com/user-attachments/assets/6f3c9fa6-e36f-433c-9309-efb230b2238b" width = "350">


### 2.2. 사용 기술
#### I. Backend
|이름|버전|
|:---:|:---:|
|SpringBoot|3.3.3|
|MYSQL|8.0.37|
|Java Oracle Open JDK | 21.0.3 |
#### II. Frontend
|이름|버전|
|:---:|:---:|
|Android Studio|Iguana : 2023.2.1|

#### III.Cloud Services
|이름|
|:---:|
|AWS|
|Azure|

## 3. 개발결과
### 3.1. 전체시스템 흐름도
#### I. 전체 시스템 흐름도
<img src = "https://github.com/user-attachments/assets/be3a8300-07d4-4725-903d-6f6929c12123" width = "600">

#### II. 환불 시스템 흐름도
<img src = "https://github.com/user-attachments/assets/9b051e98-d261-4a49-a48f-c3a5a780ee61" width = "600">

### 3.2. 기능설명
####  I. 홈화면 배너
>홈화면 배너에 신규/할인 헬스장을 배너에 홍보. 양 옆에 화살표로 볼 수 있음.</br>
>더 알아보기를 통해 목록 스크롤 페이지로 이동할 수 있음

#### II. 목록 스크롤
>목록 스크롤 페이지에서 내 지역 주변 등록 헬스장을 볼 수 있음. 이름, 별점, 월별 가격을 한눈에 볼 수 있음.</br> 찜하기를 눌러 관심 헬스장 목록에 넣을 수 있고, 원하는 헬스장 아이템을 선택하면 디테일 페이지로 이동함
>

https://github.com/user-attachments/assets/5c27cd60-934a-4304-b44e-7c56bcf11b3f




#### III. 디테일 페이지
>이름, 별점, 장기 회원권 가격을 한눈에 볼 수 있음.</br> 찜하기를 눌러 관심 헬스장 목록에 넣을 수 있고, 회원권을 누르면 결제 페이지로 이어짐.



https://github.com/user-attachments/assets/b20a42a6-9883-41b6-a4fa-e42f651c0c44




#### IV. 회원권 구매
>사용자 계좌의 전자 지갑 주소와 등록된 헬스장의 전자 지갑 주소를 기반으로 스마트 컨트랙트가 실행됨. 스마트 컨트랙트는 이더리움 네트워크에 배포되었고 chainlink에서 정해진 시간 (매달) 스마트 컨트랙트를 호출하여 스마트 컨트랙트에서 매달 정기적으로 대금을 헬스장 계좌에 분할 납부하도록 하였음.
>
https://github.com/user-attachments/assets/70b479ef-851e-430f-9f76-b119e8fe3d84

#### V. 소비자 신고 
> 마이 페이지에서 소비자 신고 센터를 눌러 신고 접수란으로 이동할 수 있음. 내용을 적고 입력하면 소비자 신고가 접수되어 헬스장 폐업 사실 여부를 알아볼 것.

> [신고_최최종.webm](https://github.com/user-attachments/assets/1e132fa3-7bb2-48b5-aebf-859c0b76789c)


#### VI. 환불
> 소비자 최초 신고가 들어오면 해당 헬스장을 이용하는 다른 소비자들은 팝업 알림으로 헬스장의 폐업 사실을 받음. 팝업 알림을 누르면 환불 절차 안내와 함께 멀티 시그 승인 요청을 받음. 이후 환불받을 수 있음.

### 3.3. 기능명세서
#### I. 로그인/회원가입

 <img src = "https://github.com/user-attachments/assets/75496eee-19c5-407b-a47b-83855729602d" width = "600">
 
|라벨|이름|상세|
|:---:|:---:|:---:|
|S1|로그인| 클릭시 로그인 페이지 이동|
|S2|회원가입하러가기| 클릭시 회원가입 페이지 이동|
|S3|로그인 : 이메일 주소| 이메일 입력 </br> 유효성 검사|
|S4|로그인 : 비밀번호| 비밀번호 입력 </br> 유효성 검사 |
|S5|로그인 : 가입하기| 클릭시 회원가입 페이지 이동 |
|S6|회원가입 : 아이디| 아이디 입력 </br> 중복 검사 |
|S7|회원가입 : 이메일 주소| 이메일 입력 </br> 중복 검사 |
|S8|회원가입 : 비밀번호| 비밀번호 입력 </br> 중복 검사 |
|S8|회원가입| 회원가입 |
<hr>

#### II. 검색
 <img src = "https://github.com/user-attachments/assets/c471f69f-ca1c-41d4-a698-fd2acb36a6d5" width = "200">
 
|라벨|이름|상세|
|:---:|:---:|:---:|
|S1|검색| 연관 검색어 검색 |
<hr>

#### III. 스크롤 목록 배너
 <img src = "https://github.com/user-attachments/assets/3fd0ab09-cc43-4ac1-a95c-85625ccf9a2e" width = "200">

|라벨|이름|상세|
|:---:|:---:|:---:|
|S1|검색| 연관 검색어 검색 |
|S2|목록 아이템| 디테일 페이지로 이동 |
<hr>

#### IV. 디테일 페이지
 <img src = "https://github.com/user-attachments/assets/c47f7eb1-25fa-4ab0-abc8-fbf382c576bc" width = "200">

|라벨|이름|상세|
|:---:|:---:|:---:|
|S1|찜하기| 관심 목록 저장 |
|S2|리뷰 보기| 리뷰 페이지 이동 |
|S3|회원권| 회원권 구매 </br> 결제 페이지로 이동|
<hr>

#### V. 환불 페이지
 <img src = "https://github.com/user-attachments/assets/e9f6a1e0-ce3c-48c3-b452-37d656dc26d8" width = "400">

|라벨|이름|상세|
|:---:|:---:|:---:|
|S1|폐업 업장 정보| 결제일, 회원권 정보 확인 |
|S2|환불 정책 보기| 환불 정책 상세 페이지 이동 |
|S3|환불 금액| 환불 금액 명시|
|S4|승인| 멀티시그 환불 승인 </br> 완료 페이지로 이동|
|S5|확인|완료|
<hr>

#### VI. 신고 페이지
 <img src = "https://github.com/user-attachments/assets/fcb3fbed-a38d-4ba5-b3e9-be2eacc4d9c4" width = "400">
 
|라벨|이름|상세|
|:---:|:---:|:---:|
|S1|폐업 업장 지역| 지역 작성 |
|S2|폐업 업장 이름| 이름 작성 |
|S3|폐업 업장 사유| 사유 작성 |
|S4|폐업 업장 신고| 신고 접수 |
<hr>

#### VII. 결제 페이지
<img src = "https://github.com/user-attachments/assets/3036d155-af33-4241-9e2f-694829468edc" width = "200">

|라벨|이름|상세|
|:---:|:---:|:---:|
|S1|헬스장 전자 계좌 주소| 스마트 컨트랙트를 실행할 판매자 전자 계좌 주소 |
|S2|약관 동의| 약관 동의 |
<hr>

#### VIII. 마이 페이지
<img src = "https://github.com/user-attachments/assets/38724d33-9451-4dac-95f6-607742f62582" width = "200">

|라벨|이름|상세|
|:---:|:---:|:---:|
|S1|소비자 전자 계좌 주소| 앱에서 발행한 소비자 전자 계좌 주소 |
|S2|소비자 신고 센터| 클릭 시 신고 페이지로 이동  |
<hr>

#### IX. 홈 페이지
<img src = "https://github.com/user-attachments/assets/3ce71ecb-3344-4f54-9f9f-fb4865439702" width = "200">

|라벨|이름|상세|
|:---:|:---:|:---:|
|S1|내 지역| 내 지역 표시|
|S2|마이페이지| 클릭시 마이 페이지 이동|
|S3|검색바| 검색 페이지로 이동 |
|S4|메인 배너| 메인 배너 홍보 |
|S5|화살표 |메인 배너 교체 |
|S6|주변 운동시설 보기| 목록 스크롤 페이지로 이동 |
|S7|지도 아이콘| 지도 페이지로 이동|



### 3.4. 디렉토리 구조
> 위 레포지토리의 디렉토리 구조를 설명하세요.

## 4. 설치 및 사용 방법
> APK 파일을 통해 앱 테스트를 진행.
> 링크를 통해 APK 파일 다운로드 후 설치 진행 <br/>
[APK 드라이브](https://drive.google.com/file/d/1yJMPVmnZXisfN_Gc7vMa-p_CNnMgf_0d/view?usp=sharing)

## 5. 소개 및 시연 영상
> https://youtu.be/czMydZbLipo
## 6. 팀 소개
|이준영 | 신승훈 | 문진서 | 지아선 | 백승광 |
|:-------:|:-------:|:-------:|:-------:|:-------:|
| | | | | |
| liy03@pusan.ac.kr | uitopia04@pusan.ac.kr | jshin27@pusan.ac.kr | jeeasun@naver.com | 0321bsg@naver.com |
| 블록체인 개발 <br/> 기획| DB & 인프라 구축 <br/> 백앤드 개발 | 안드로이드 개발 <br/> 디자인 | 기획 | 디자인 |

## 7. 해커톤 참여 후기
- 이준영
  > 장기간 하나의 프로젝트를 해보는 경험이 처음이라 어느정도의 구현을 요구하는지 내가 할 수는 있을지 여러모로 자신이 없었는데, 부딪혀봐야 는다는 사실을 몸소 깨닫는 대회였다. 3개월동안 지난 1년 반 가량의 학부 생활 중 가장 많은 실력의 성장을 이루었다 생각한다. 새로운 것을 배우고, 아이디어를 내고, 구현하고. 이 길이 내 길이 맞다는 걸 다시한번 느끼는 경험이었다
- 신승훈
  > 첫 해커톤이기에 백엔드와 앱 개발 부터, 협업, 그리고 프로젝트를 하기 위해 무엇이 필요한지 다양한 방면의 경험을 할 수 있었다. 많은 것을 배울 수 있었던 소중한 기회였다.
- 문진서
  > 장기간 프로젝트를 진행해본것이 처음이라 끝이 보인다는것 자체의 기쁨이 크다. 처음엔 페이지 하나 완성하는 것만으로도 기뻤는데 하다보니 점점 실력이 느는게 느껴져 좋은 경험이었다고 생각한다. 많은 일이 있었는데 다들 열심히 해줘서 고맙고 좋은 팀원들을 만나 성장한것 같아 뿌듯하다. 이번 해커톤을 본보기로 삼아 다른 프로젝트나 대회에서는 더 발전된 모습을 보이고 싶다.
- 지아선
  > 해커톤의 정의는, 일정한 시간에 기획자·개발자·디자이너 등이 팀을 꾸려 새로운 비지니스 모델을 완성하는 것이다. 나는 이번 해커톤에서 기획자로서 많은 아이디어를 내놓았다. 창의적이지만 구현하기 어려운 아이디어들을 해커톤이라는 특성 때문에 내보이지 못한것에 아쉬움이 크다. 이번 해커톤을 계기 삼아, 비지니스 모델을 만드는 도전을 더 하고 싶다. 쟁쟁한 참여팀들의 모델을 관찰하며 얻을 관점또한 많았다. 우리 팀의 결과물과 비교하며 어떤 점이 취약점인지 확인할 수 있었고, 얻은 관점을 다른 상황에서도 충분히 사용할 수 있을 것 같다.미래에 어떤 걸 기획하게 될지는 모르겠지만 기획자로서의 성장이 기대된다. 
- 백승광
  > sw 공모전을 진행하면서 아이디어 회의, 개발, 포스터 디자인등에 참여하면서 여러 어려움을 겪었지만 팀원들과 함께 헤쳐나가며 성장할 수 있는 경험을 쌓게 되었다.  중간 발표 이후 프로젝트의 문제점을 발견하고, 이를 해결하기 위해 팀원 모두가 협력하여 노력한 과정이 기억에 남는다. 각자의 전문성을 살려 수정과 보완 작업을 통해 프로젝트를 완성했으며, 그 과정에서의 성취감을 느낄 수 있었다.

<br/>
