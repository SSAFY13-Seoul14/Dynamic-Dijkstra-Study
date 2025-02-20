# 알고리즘 스터디 팀 레포지토리

이 저장소는 알고리즘 문제 풀이 스터디를 위한 팀 레포지토리입니다.

---

## 1. 문제 등록 방법

새로운 문제는 **Issue**를 통해 등록하며, 아래 규칙을 따라주세요:

- **문제 제목 형식**: `BOJ [문제번호]번: [문제 이름]`
예시: `BOJ 1000번: A+B`
- **레이블**: `new problem` (`task` 타입도 함께 지정)
- **내용**: 문제 설명을 [Markdown](https://guides.github.com/features/mastering-markdown/) 형식으로 복사하여 붙여넣어 주세요.
- **참고:** [OnlineJudge MarkDown 익스텐션](https://chromewebstore.google.com/detail/oj-md/ofbkmnfidhpjpglbjgooomdjppeleldl)을 사용하면 BOJ 문제를 바로 Markdown 형식으로 복사할 수 있습니다.
- `BOJ/1000` 형식으로 브랜치를 생성하여 Issue와 링크시켜주세요.

---

## 2. 문제 풀이 및 Pull Request 제출

문제 풀이가 완료되면 **Pull Request (PR)**를 통해 제출해 주세요.

- **PR 제목**: 등록된 Issue 제목과 동일하게 작성해 주세요.
예시: `BOJ 1000번: A+B`
- **PR 내용**:
    - 문제 풀이 방법 및 접근 방식을 상세하게 설명해 주세요.
    - 사용한 알고리즘, 시간 복잡도, 코드의 주요 부분을 포함해 주세요.
    - 관련 Issue 번호를 명시해 주세요 (예: `Resolves #12`).
    - **코드 스타일**: 사용하는 프로그래밍 언어의 공식 스타일 가이드를 준수해 주세요.
    (예: Python의 경우 PEP 8, C++의 경우 Google C++ Style Guide 등)

---

## 3. 문제풀이 폴더 생성 규칙

각 문제에 대한 풀이 코드는 별도의 폴더에 관리해 주세요. 폴더명은 아래 형식을 따릅니다:

- **폴더 및 파일 이름 형식**:  `lib/main/src/boj/no[문제번호]/[본인 github 아이디]/Main.java`
    - 예시: `lib/main/src/boj/no1000/parkjbdev/Main.java` (java만 대문자로 시작)
    - 예시: `lib/main/src/boj/no1000/parkjbdev/main.py`
    - 예시: `lib/main/src/boj/no1000/parkjbdev/main.cpp`

폴더 내에는 문제 풀이 코드와 함께 README 파일 등을 포함하여 풀이에 대한 설명을 덧붙여 주시면 좋습니다.

---

## 4. 코드 리뷰 및 피드백

- PR 제출 후 팀원들이 코드 리뷰를 진행합니다.
- 리뷰어의 피드백이 있을 경우, 수정 후 다시 PR을 업데이트해 주세요.
- 모든 리뷰 과정에서는 서로 예의를 지키며 건설적인 피드백을 주고받아 주세요.

---

## 5. 커뮤니케이션

- 문제 관련 토론이나 질문은 **Issue 댓글**이나 팀 커뮤니케이션 채널(Slack, Discord 등)을 통해 진행해 주세요.
- 함께 문제를 해결하는 과정에서 활발한 의견 교환을 부탁드립니다.

---

## 6. 기타 기여

- 새로운 아이디어, 개선 사항 등도 언제든지 환영합니다.
- 레포지토리 관리나 도구 관련 제안이 있을 경우 Issue를 통해 공유해 주세요.

---

여러분의 기여가 모여 모두가 성장하는 좋은 학습 환경이 만들어집니다.  
적극적인 참여 부탁드리며, 기여해 주셔서 감사합니다!

Happy Hacking & Good Luck!
