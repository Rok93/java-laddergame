# 사다리 게임
### 요구사항
<ul>
<li>사다리 게임에 참여하는 사람의 이름을 최대 5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다. </li>
<li>사람 이름은 쉼표(,)를 기준으로 구분한다.</li>
<li>사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.</li>
<li>사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.</li>
<li> |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.</li>
</ul>

### 구현할 기능 목록 (구현한 기능은 ~~example~~ 처리)
~~~
 1. 사다리 게임에 참여하는 사람의 이름을 받는 기능
  1-1) Name Wrapping Class 생성
      예외: 사람의 이름이 1글자 미만 경우 
      예외: 사람의 이름이 5글자를 초과하는 경우 
  1-2) Names 일급 컬렉션 생성
      예외: 참가자가 2명 미만인 경우 
 2. 사다리의 높이를 입력받는 기능
  2-1) Height Wrapping Class 생성 
      예외: 높이가 1보다 작은 경우 
 3. 사다리를 생성하는 기능 
  3-1) Line 일급 컬렉션 생성 (List<Boolean> type, 사다리의 한 행을 담당) 
      예외: 인접한 원소가 중복하는 경우 
  3-2) Ladder 일급 컬렉션 생성 (List<Line>) type, 사다리의 열을 
 4. 실행결과를 출력하는 기능
~~~

