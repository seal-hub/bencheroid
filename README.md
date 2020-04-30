# Concurrency Benchmark
## Entities 
### External
* Concurrency API
	* Thread, Handler, AsyncTask, Executor, Timer, IntentService
* Synchronization Mechanism
	* Thread constructs, Looper, withDelay, AtFrontOfQueue, Serial, Parallel
* Involved Components
	* Activity, Service, Receiver
* Android Callbacks
	* LifeCycle (onCreate, onStart, ..., onDestroy), EventListener (onClick, onLocationChanged, etc.	)
* Inter-Component Communication (ICC)
	* 	Yes/No

### Internal
* Input (Path), Execution Order, Thread, Time
	* 	Yes/No


## Benchmark App Info
The locations of event races are represented as *[Event1, Event2, Field]* where Event1 and Event2 are defined as *FileName (Line Number)*. The more detailed list can be found in [this google sheet](https://docs.google.com/spreadsheets/d/1dj9SPCKxUDIGwRgBsUjtdBfitT8pcvSm8HbscgZeQTA/edit?usp=sharing).

|Id|Name| Concurrency API | Synchronization Mechanism | Involved Components | Android Callbacks | ICC | Internal Entities | #ER | ER Location(s)|
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
|1|AsyncTask1|AsyncTask|Parallel|Activity|LC, EL|&#10060;|Thread|1|[MainActivity.java (61), MainActivity.java (47), coordinates]|
|2|AsyncTask2|AsyncTask|Serial|Activity|LC, EL|&#10060;|Execution Order,Thread|0|&empty;|
|3|AsyncTask3|AsyncTask|Parallel|Activity|LC, EL|&#10060;|Input,Thread|1|[MainActivity.java (51), MainActivity.java (48), coordinates]|
|4|AsyncTask4|AsyncTask|Parallel|Activity|LC, EL|&#10060;|Thread|1|[MainActivity.java (62), MainActivity.java (48), coordinates]|
|5|AsyncTask5|AsyncTask|Parallel, Serial|Activity|&empty;|&#10060;|Thread|1|[MainActivity.java (44), MainActivity.java (44), A]|
|6|AsyncTask6|AsyncTask|Serial|Activity|&empty;|&#10060;|Thread|0|&empty;|
|7|Executor1|Executor|&empty;|Activity|LC, EL|&#10060;|&empty;|1|[MainActivity.java (48), MainActivity.java (31), coordinates]|
|8|Executor2|Executor|Serial|Activity|&empty;|&#10060;|Execution Order|1|[MainActivity.java (33), MainActivity.java (42), B]|
|9|LifeCycle1|&empty;|&empty;|Activity|LC|&#10060;|&empty;|3|[MainActivity.java (20), MainActivity.java (56), onDestroy_onCreate], [MainActivity.java (43), MainActivity.java (25), onStart_onStop], [MainActivity.java (37), MainActivity.java (31), onResume_onPause]|
|10|LifeCycle2|&empty;|&empty;|Activity|LC, EL|&#10060;|&empty;|0|&empty;|
|11|LifeCycle3|&empty;|&empty;|Activity|LC|&#10060;|&empty;|2|[MainActivity.java (33), MainActivity.java (42), onResume_onScrollChange], [MainActivity.java (26), MainActivity.java (48), onClick_onStop]|
|12|LifeCycle4|Thread|&empty;|Activity|LC|&#10060;|Time|1|[MainActivity.java (33), MainActivity.java (47), coordinates]|
|13|Looper1|Handler|Looper|Activity|LC, EL|&#10060;|Execution Order, Input, Thread|0|
|14|Looper2|Handler|Looper|Activity|LC, EL|&#10060;|Thread|1|[MainActivity.java (47), MainActivity.java (54), coordinates]|
|15|Looper3|Handler|Looper, AtFrontOfQueue|Activity|&empty;|&#10060;|&empty;|1|[MainActivity.java (29), MainActivity.java (23), A]|
|16|MultiComp1|&empty;|&empty;|Activity,BroadcastReceiver|LC, EL|&#9989;|Input|2|[MainActivity.java (58), MainActivity.java (51), A],[MyReceiver.java (16),	Main2Activity.java (24), memoryObject.object]|
|17|Receiver1|&empty;|&empty;|Activity,BroadcastReceiver|&empty;|&#10060;|&empty;|1|[MainActivity.java (29), MainActivity.java (18), coordinates]|
|18|Service1|&empty;|&empty;|Activity,Service|LC, EL|&#9989;|Input|0|&empty;|
|19|Service2|Handler|withDelay|Activity,Service|LC, EL|&#9989;|&empty;|3|[MainActivity.java(42), MyService.java (22), myMemoryObject], [MainActivity.java(48), MainActivity.java (32), secondMemoryObject],[MainActivity.java(49), MainActivity.java (32), myBinder]|
|20|Service3|IntentService|&empty;|Activity,Service|LC|&#9989;|&empty;|1|[MainActivity.java(27), Service3.java(26), mCoordinates]|
|21|Service4|IntentService|Serial|Activity,Service|LC|&#9989;|Execution Order|0|&empty;|
|22|Service5||Serial|Activity,Service|LC|&#9989;|&empty|1|[MainActivity.java(36), MyService.java (18), A]|
|23|SingleActivity1|&empty;|&empty;|Activity|EL|&#10060;|&empty;|1|[MainActivity.java(35), MainActivity.java (31), memoryObject]|
|24|SingleActivity2|Handler|&empty;|Activity|&empty;|&#10060;|&empty;|0|&empty;|
|25|SingleActivity3|Handler|&empty;|Activity|&empty;|&#10060;|Thread|1|[MainActivity.java(22), MainActivity.java (22), memoryObject]|
|26|SingleActivity4|Handler|Looper, withDelay, AtFrontOfQueue|Activity|LC|&#10060;|Execution Order, Time|0|&empty;|
|27|SingleActivity5|Handler|Looper|Activity|LC|&#10060;|Execution Order|2|[MainActivity.java(24), MainActivity.java (43), A],[MainActivity.java (52), MainActivity.java (33), D]|
|28|SingleActivity6|Thread, Handler|Looper|Activity|LC|&#10060;|Execution Order, Thread|2|[MainActivity.java(20), MainActivity.java (27), A],[MainActivity.java (32), MainActivity.java (38), C]|
|29|SingleActivity7|Handler|Looper|Activity|LC, EL|&#10060;|Execution Order, Thread|2|[MainActivity.java(24), MainActivity.java (25), B]|
|30|SingleActivity8|Handler, AsyncTask|Looper|Activity|LC, EL|&#10060;|Execution Order|2|[MainActivity.java(30), MainActivity.java (51), A], [MainActivity.java (41), MainActivity.java (23), flag]|
|31|TimerTask1|Timer|withDelay|Activity|LC, EL|&#10060;|&empty;|1|[MainActivity.java(37), MainActivity.java(51), coordinates]|
|32|TimerTask2|Timer|withDelay|Activity|&empty;|&#10060;|Time|1|[MainActivity.java(27), MainActivity.java(37), A]|
|33|Thread1|Thread|wait/notify|Activity|&empty;|&#10060;|Thread|1|[MainActivity.java(32), MainActivity.java(25), secondMemoryObject]|
|34|Thread2|Thread|wait/notify|Activity|&empty;|&#10060;|&empty;|1|[MainActivity.java(32), MainActivity.java(46), secondMemoryObject]|
