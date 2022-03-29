Git에게 맞기지 않을 것들
===
Git의 관리에서 특정 파일/폴더를 배제해야 할 경우
- 포함할 필요가 없을 때
  - 자동으로 생성 또는 다운로드되는 파일들(빌드 결과물, 라이브러리)
- 포함하지 말아야 할 때
  - 보안상 민감한 정보를 담은 파일

.gitignore사용
---
폴더 아래 파일 생성
- secrets.yaml
  ```yaml
  id: admin
  pw: 1234abcd
  ```
- 작성 후 git status명령으로 관리 파일에 secrets.yaml이 추가된 것을 확인 하기
- .gitignore파일 생성 후 배제시킬 파일의 이름 작성
  ```
  secrets.yaml
  ```
- 다시 git status명령으로 확인 해보기

  <img src="../img/Git/gitignoreAndGitStatus.jpg" width="60%">
  
  위의 이미지와 같이 깃의 관리파일에서 secrets.yaml파일이 제외된 것을 볼 수 있다.

.gitignore 형식
---
gitignore형식 [참조](http://git-scm.com/docs/gitignore)
```
# 주석

# 모든 file.c
file.c

# 최상위 폴더의 file.c
/file.c

# 모든 .c 확장자 파일
*.c

# .c 확장자지만 무시하지 않을 파일
!not_ignore_this.c

# logs란 이름의 파일 또는 폴더와 그 내용들
logs

# logs란 이름의 폴더와 그 내용들
logs/

# logs 폴더 바로 안의 debug.log와 .c 파일들
logs/debug.log
logs/*.c

# logs 폴더 바로 안, 또는 그 안의 다른 폴더(들) 안의 debug.log
logs/**/debug.log
```