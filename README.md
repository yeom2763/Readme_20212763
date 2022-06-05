# Readme_20212763
---
## $top 
[운영체제의 현재 상태를 나타내주는 CLI 어플리케이션(명령어 인터페이스)]

## top 인터페이스 레이아웃 (예시) 
```
top - 15:32:30 up  4:33,  0 users,  load average: 0.00, 0.00, 0.00
Tasks:  10 total,   1 running,   9 sleeping,   0 stopped,   0 zombie
%Cpu(s):  0.0 us,  0.0 sy,  0.0 ni,100.0 id,  0.0 wa,  0.0 hi,  0.0 si,  0.0 st
MiB Mem :  12686.9 total,  10952.5 free,    646.0 used,   1088.4 buff/cache
MiB Swap:   4096.0 total,   4096.0 free,      0.0 used.  11428.4 avail Mem
  PID USER      PR  NI    VIRT    RES    SHR S  %CPU  %MEM     TIME+ COMMAND
    1 root      20   0     896    528    464 S   0.0   0.0   0:00.01 init
  134 root      20   0     896     84     20 S   0.0   0.0   0:00.00 init
  135 root      20   0     896     84     20 S   0.0   0.0   0:00.00 init
  136 root      20   0 1827568  35196  13312 S   0.0   0.3   0:00.34 docker-desktop-
  149 root      20   0     896     84     20 S   0.0   0.0   0:00.00 init
  150 user 20   0  765544  50248  30648 S   0.0   0.4   0:00.85 docker
  262 root      20   0     896     84     20 S   0.0   0.0   0:00.00 init
  263 root      20   0     896     84     20 S   0.0   0.0   0:00.00 init
  264 user 20   0   10168   5188   3424 S   0.0   0.0   0:00.02 bash
277 user 20   0   10872   3716   3204 R   0.0   0.0   0:00.00 top
```

## top 레이아웃 설명 (왼쪽 상단부터 차례대로)

시스템 현재 시간, 운영체제 동작 시간, 유저 세션 수, Load Average

Tasks 

%CPU(s)

Memory

디테일 영역

## top 영역별 설명

* Load Average
  * CPU Load의 이동 평균을 의미합니다.

* Task
  * 현재 프로세스들의 상태를 나타냅니다. 
  * total, running, sleeping, stopped, zombies로 분류는 프로세스의 수를 나타냅니다.

* %CPU(s)
  * CPU가 어떻게 사용되고 있는지 사용률을 나타냅니다. 총합은 100입니다.
 각 영역은 us, sy, ni, id, wa, hi, si, st로 나뉩니다.
 이 영역 아래의 영역은 메모리의 사용량을 나타냅니다.
 메모리 사용량은 total, free, used로 분류됩니다.

* PID
  * 프로세스를 구분하기 위해 겹치지 않는 고유값

* USER
  * 해당 프로세스를 실행한 USER 이름 또는 효과를 받는 USER의 이름

* PR
  * 커널에 의해서 스케줄링 되는 우선순위

* NI
  * PR에 영향을 주는 nice값

* VIRT
  * 프로세스가 소비하고 있는 총 메모리. 실행중인 코드 힙, 스택, 버퍼를 포함합니다.

* RES
  * RAM에서 사용 중인 메모리의 크기를 나타냅니다.

* SHR
  * 다른 프로세스와의 공유 메모리를 나타냅니다.

* %MEM
  * RAM에서 RES가 차지하는 비율을 나타냅니다.

* S
  * 프로세스의 현재 상태를 나타냅니다.

* TIME+
  * 프로세스가 사용한 Total CPU Time을 나타냅니다.

* COMMAND
  * 해당 프로세스를 실핸한 커맨드를 나타냅니다.

## top 실행 옵션, 명령어

* 실행 옵션 (실행 전)

  * $ top (추가 옵션 X) - Interval 간격 (기본 3초)으로 화면을 갱신하며 정보를 표시함.
  
  * $ top -b (batch mode) - 순간의 정보를 확인 가능.

  * $ top -n - top 실행 주기 설정.

* 명령어 (실행 후)

  * shift + p : CPU 사용률 내림차순

  * shit + m : 메모리 사용률 내림차순

  * shift + t : 프로세스가 돌아가고 있는 시간 순

  * k : kill. k 입력 후 PID 번호 작성. signal은 9

  * f : sort field 선택 화면 -> q 누르면 RES순으로 정렬

  * a : 메모리 사용량에 따라 정렬

  * b : Batch 모드로 작동

  * 1 : CPU Core별로 사용량 보여줌

---
## $ps 

[현재 실행 중인 프로레스 목록과 상태를 보여줌]

## ps 레이아웃 (예시) 
```
PID TTY          TIME CMD
  280 pts/3    00:00:00 bash
  302 pts/3    00:00:00 ps
```

## ps 옵션

* -e: 모든 프로세스를 출력해 준다.

* -f: 풀 포맷으로 보여준다.(UID, PID 등)

* -l: 긴 포맷으로 보여준다.

* p, -p: 특정 PID의 프로세스를 보여준다.

* -u: 특정 사용자의 프로세스를 보여준다.

---
## $jobs 
[백그라운드에 실행되고 있는 프로세스나 중지된 프로세스의 목록을 출력합니다.]

## jos 레이아웃 (예시)  
```
[1]+ Stopped nano /home
[2] Stopped ssh localhost
```

## 영역 설명 (왼쪽 상단부터 차례대로)

번호 기호 상태 프로세스

* 번호 

  * Job의 번호를 나타냅니다.

* 기호

  * +는 fg나 bg 명령어를 사용했을 때 default로 가장먼저 가져와서 수행하게 될 프로세스를 의미합니다.

  * -는 진행 중인 job이 끝나면 다음에 수행될 프로세스를 의미합니다.

* 상태

  * Stopped, Running, Done으로 나뉘며 프로세스의 상태를 의미합니다.

---
## $kill
[프로세스에 특정 signal을 보내며, 주로 종료 시 사용됩니다.]

## kill 옵션
* -l: signal의 종류를 확인합니다.

## $kill -[signal option num or name] PID
```
 1) SIGHUP       2) SIGINT       3) SIGQUIT      4) SIGILL       5) SIGTRAP
 6) SIGABRT      7) SIGBUS       8) SIGFPE       9) SIGKILL     10) SIGUSR1
11) SIGSEGV     12) SIGUSR2     13) SIGPIPE     14) SIGALRM     15) SIGTERM
16) SIGSTKFLT   17) SIGCHLD     18) SIGCONT     19) SIGSTOP     20) SIGTSTP
21) SIGTTIN     22) SIGTTOU     23) SIGURG      24) SIGXCPU     25) SIGXFSZ
26) SIGVTALRM   27) SIGPROF     28) SIGWINCH    29) SIGIO       30) SIGPWR
31) SIGSYS      34) SIGRTMIN    35) SIGRTMIN+1  36) SIGRTMIN+2  37) SIGRTMIN+3
38) SIGRTMIN+4  39) SIGRTMIN+5  40) SIGRTMIN+6  41) SIGRTMIN+7  42) SIGRTMIN+8
43) SIGRTMIN+9  44) SIGRTMIN+10 45) SIGRTMIN+11 46) SIGRTMIN+12 47) SIGRTMIN+13
48) SIGRTMIN+14 49) SIGRTMIN+15 50) SIGRTMAX-14 51) SIGRTMAX-13 52) SIGRTMAX-12
53) SIGRTMAX-11 54) SIGRTMAX-10 55) SIGRTMAX-9  56) SIGRTMAX-8  57) SIGRTMAX-7
58) SIGRTMAX-6  59) SIGRTMAX-5  60) SIGRTMAX-4  61) SIGRTMAX-3  62) SIGRTMAX-2
63) SIGRTMAX-1  64) SIGRTMAX
```
kill 명령어는 위의 시그널 옵션의 넘버와 함꼐 조합하여 사용 할 수 있습니다.

ex) $kill -9 1234 or $kill -SIGKILL 1234 
> 이 명령어는 프로세스를 강제 종료하도록 합니다.

## vim 매크로 사용 방법

vi 에디터의 매크로 사용 flow는 다음과 같습니다.

1. recording 시작하기

  커맨드 모드에서 q + [name] 를 입력하여 recording을 시작합니다.
  
2. 키조합 입력하기.

  원하는 키조합을 입력하여 기록합니다.
  
3. recording 종료하기

  키조합을 입력 후 커맨드 모드로 돌아와 'q'를 눌러 recording을 종료합니다.
  
4. 매크로 실행하기

  @[name], @@, [num]@[name]을 입력하여 매크로를 실행합니다.
  

## 매크로 실행 명령어

* @[name]

  * 매크로를 1회 실행합니다.   
  
* @@

  * 방금 실행한 매크로를 실햄합니다.
  
* [num]@[name]

  * 매크로를 num 횟수만큼 실행합니다.
