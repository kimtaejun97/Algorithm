# 🕹 Algorithm
🧐 Algorithm Study
****




## 📌 LinkedHashMap의 removeEldestEntry()
***
> LinkedHash Map은 HashMap을 상속, 기본 기능은 같으나 순서를 가지고 있다.



### 🧐 removeEldestEntry()
- put을 할 때 호출.
- 가장 최근에 들어온 데이터들을 일정 개수로 유지하고자 할 때 사용 가능.
- eldest로 가장 오래된 엔트리를 알고있다.
#### - 기본 정의
```java
protected boolean removeEldestEntry(Map.Entry<K,V> eldest){
    return false;
}
```

####- 재정의
```java
protected boolean removeEldestEntry(Map.Entry<K,V> eldest){
    return size() > 3;
}
```
> 사이즈가 3보다 커지면 가장 오래된 값을 지우고, 그 자리를 방금 들어온 엔트리로 대체한다.



# 📌 Matches, Pattern
****
```java
String pattern = "^[A-Z]*$";
boolean regex = Pattern.matches(pattern, elm);
        if(regex){
            return true;
        }

        return false;
```
- 두번째 인자의 문자열이 패턴과 일치하면 true 반환.

# 📌 Stream, reduce와 mapToInt
***
```java
answer = scores.stream().mapToInt(score -> score).sum();

scores.stream().reduce(0,Integer::sum);
```
- 두 라인 모두 Stream 내의 요소들을 int값으로 더하기 위한 코드이다.
- 하지만 속도를 측정해보면 mapToInt가 더 좋은 성능을 보여준다
- 🤔 reduce의 경우에는 박싱, 언박싱의 과정을 거치기 때문에 속도가 더 느리다.


# 📌 Map Sort와 getOrDefault
***

### 🧐 Map.Entry.comparingBy*
```java
List<Map.Entry<Integer, Integer>> orderByValue = elmCount.entrySet().stream()
            .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toList());
```
- comparingByValue | comparingByKey를 사용하Map을 정렬할 수 있다.
- 기본적으로 오름차순, 내림차순으로 정렬하고 싶다면 아래와 같이 할 수 있다.
```java
.sorted(reverseOrder(Map.Entry.comparingByValue))
```


### 🧐 getOrDefault
```java
if(elmCount.containsKey(elmValue)){
    elmCount.put(elmValue, elmCount.get(elmValue) +1);
}
else{
   elmCount.put(elmValue, 1);
}
```
```java
 map.put(n, map.getOrDefault(n, 0) + 1);
```
- 위의 코드를 getOrDefault를 사용하여 아래 코드로 변경할 수 있다


# 📌 StringBuffer : 문자열의 특정위치 치환.
****
```java
String road = "00010101101"
StringBuffer stringBuffer = new StringBuffer(road);
StringBuffer newRoad = stringBuffer.replace(startIdx, endIndex, "1");

```
- startIdx부터 endIdx -1 까지의 범위를 3번째 인자의 문자열로 치환한다.

# 📌 완전탐색: n개에서 m개를 선택, 재귀사용.
***
```java
public int pick(String road,List<Integer> zeroIndex, int n){
        if(zeroIndex.size() == 0){
            return getRoadLength(road);
        }

        int maxLength = 0;
        StringBuffer stringBuffer;
        List<Integer> myZeroIndex = new ArrayList<>();

        // idex List 복사
        myZeroIndex.addAll(zeroIndex);

        for(int i=0; i<myZeroIndex.size(); i++){
            myZeroIndex.clear();
            myZeroIndex.addAll(zeroIndex);
            stringBuffer = new StringBuffer(road);

            int idx = myZeroIndex.remove(i);
            int length = 0;

            // 도로 한 곳 보수
            StringBuffer newRoad = stringBuffer.replace(idx, idx+1, "1");

            // 재귀로 보수된 도로 받아오기
            if(n > 1){
                length = pick(newRoad.toString(), myZeroIndex, n-1);
            }
            // 마지막 재귀호출
            else{
                length = getRoadLength(newRoad.toString());
            }
            if(length > maxLength){
                maxLength = length;
            }
        }
        return maxLength;
    }
```
> - n개의 선택지에서 m개를 고를 때 가장 최선의 선택이 되도록 하는 알고리즘.
> - 메서드 에서는 n-1개의 선택지로 다시 재귀호출.
> - 재귀호출에서는 자신에게 주어진 선택지를 모두 탐색. 최적의 값을 반환.
> - 즉 자신이 1개를 고르고, 나머지 선택지를 재귀호출로 넘겨준다. 각 재귀호출 메서드에서는 또 그중 하나를 선택하고 재귀호출.
> m개를 선택 한 후에 값 계산.



# 📌 Iterator 을 이용한 ConcurrentModificationException 해결
***
> Collection을 for문으로 탐색하다가 해당 인덱스 , 또는 Object로 요소를 add/remove 하려고 하면, 다른 요소들의 인덱스에 변화가 생기기 때문에 예외가 발생한다.
> 
- remove
```java
 for(Iterator<String> it = dir.iterator(); it.hasNext();){
        if(it.next().startsWith(split[1])){
        it.remove();
    }
}
```
- Iterator를 사용하고, remove할 때에는 iterator 자체를 remove해서 제거해준다.


- add
    - 다른 리스트에 넣어 두었다가 순회가 끝난 후 addAll
    

# 📌 Arrays.sort
***
> 배열의 오름차순, 내림차순 정렬.

- 오름차순 정렬
```java
Arrays.sort(arr);
```

- 내림차순 정렬
```java
Arrays.sort(arr,Collections.reverseOrder())
```

- 커스텀 정렬
```java
Arrays.sort(arr, new Comparator<..>{...})
```
> 🖍 Comparator을 사용할 때는 IllegalArgumentException이 발생하지 않도록 항상 -1,0,1을 반환할 수 있도록 구현한다
> ```java
> return o1 - o2 or 조건문을 사용하여 -1,0,1을 모두 반환할 수 있도록 구현.
> ```
> 🤔 sort함수에서는 Comparator의 검증을 적극적으로 하지는 않지만 입력 데이터에 따라 실행 도중 잘못되었다는 증거를 발견하게 되면 런타임 예외를 발생시킨다.

# 📌 우선순위 큐 
***
```java
 PriorityQueue<Integer> que = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return 0;
            }
        });
```
- Comparator을 생략하면 기본적인 오름차순.
- pick() -> 가장 앞의 요소를 확인. 없다면 null
- poll() -> 가장 앞의 요소를 꺼내온다.(remove) 없다면 null
- remove() -> 맨 앞의 요소 제거. boolean 반환.
- clear() -> 큐를 비운다.


# 📌 String 내림차순 정렬
***
```java
char[] chars = numString.toCharArray();
Arrays.sort(chars);

StringBuilder sb = new StringBuilder(new String(chars)).reverse();
System.out.println(sb.toString());
```
- 먼저 String을 charArray로 만들어 준 후 Arrays.sort()를 이용하여 오름차순 정렬.
- charArray를 다시 new String(char[])로 String으로 만들어준다.
- StringBuilder.reverse로 역순으로 정렬.

> Collections.reverseOrder()를 사용하기 위해 Charactor 배열을 생성하고, charAt으로 배열을 채우는 방법도 가능하다.


# 📌 이분 탐색
***
```java
while(start <= end){
    mid = (start + end) / 2;
    if(uniqueCoors.get(mid) == c){
        index = mid;
        break;
    }
    else if(uniqueCoors.get(mid) > c){
        end = mid -1;
    }
    else{
        start = mid +1;
    }
}
```
- 기본적인 이분탐색 알고리즘.

````java
Arrays.binarySearch(arr, findValue);
````
- 값이 존재하면 index를 반환.
- 존재하지 않으면 해당 배열에 들어간다면 들어가게 되는 index의 음수 -1을 반환한다
> ex) {1,3,4,5} -> 2를 찾는다면 -2 반환.

# 📌 List.subList(start, end)
***
- 부모 리스트를 참조하는 subList를 생성한다.
- 참조임에 유의.
 ```java
List<String> sub = new ArrayList<>(parent.subList(start, end));
```
- 위 처럼 사용하면 참조가 아니고 리스트의 일부를 복사한 리스트가 생성된다.

# 📌 BigInteger, BigDecimal
***
- 기본형 이상의 수를 다룰 때 사용한다.
```java
BigInteger number = new BigInteger(num);
number.add(BigInteger val);
number.subtract(BigInteger val);
number.multiply(BigInteger val);
number.divide(BigInteger val);
number.remainder(BigInteger val);

// 기본형으로 반환
number.intValue()
...

// 기본형 반환, 타입의 범위를 벗어나면 예외 발생.
number.intValueExact()
```
- BigDecimal 또한 동일하게 사용한다.

- String으로 변환 후 숫자를 더해 출력하는 것보다 속도가 느리다.

# 📌 BFS - queue
***
1. 큐 생성.
```java
Queue<Integer> queue = new LinkedList<>();
```
2. 첫 노드 탐색.
```java
queue.add(0);
visited[0] = true;
```
3. 노드 탐색.
```java
while(!queue.isEmpty()){
    // queue에서 이번 순서 노드를 가져옴.
    int node = queue.poll();
    
    // 해당 노드가 조건에 부합하는지 검사.
    if(조건 검사){...}
    
    // 현재 노드의 방문하지 않은 자식 노드들을 queue에 추가.
    for(자식 노드 i){
        if(!visited[i]){
            queue.add(i);
            visited[i] = true;
        }
    }
}
```


# 📌 배열의 깊은 복사.
***
- 1차원 배열의 경우 
```java
boolean copy = originArr.clone();

boolean copy = System.arraycopy(origin,0, copy, 0, origin.length);
```
- 2차원 배열
- 위처럼 단순히 clone을 하게 된다면 origin[i][j]에서 j를 가르키는 origin[i] 부분만 깊은 복사가 되고 실제 값은 깊은 복사가 되지 않는다.
```java
boolean copy = new boolean[n][n];

// 1번 방법
for(int i=0; i<n; i++){
    copy[i] = originArr[i].clone();   
}
// 2번 방법
for(int i=0; i<n; i++){
    System.arraycopy(origin[i],0, copy[i], 0, origin[i].length);
}
```


# 📌 Comparator.comparingInt()
***
```java
int[][] arr = new int[n][n];
Arrays.sort(line, Comparator.comparingInt(c -> c[0]));
```
- arr[n][0] 값을 가지고 오름차순 정렬.


# 📌 최대공약수(GCD)와 최소공배수 : 유클리드 호제법
***
### ☝️ 최대 공약수
- a >=b 이고, r = a % b 일때 GCD(a,b) == GCD(b,r)
  - ex) GCD(259,63) == GCD(63,7) == GCD(7, 0) -> 최대공약수는 7이다.
- 🖍 실제로 구현할 때는 a 와 b중 어느것이 큰지 신경쓰지 않아도 된다, a가 b보다 작더라도 다음 반복에 b,a로 뒤집어져 들어가기 때문.
  (GCD(16, 24) -> r= 16, b = 24가 됨, 다음 GCD(24,16)

### ☝️ 최소 공배수
- a,b 그리고 a와 b의 최대공약수를 l 이라고 할 때, a=Al, b=Bl 이다.
- 최소 공배수는 A * B * l 이므로 a * b / l 이다.

```java
// 반복문
int LCM = a * b;

int r = a % b;
while(r > 0){
    a = b;
    b = r;
    r = a % b;
}
int GCD = b;
LCM /= GCD;

// 재귀
private static int gcd(int a, int b) {
    if(b <= 0) return a;
    return gcd(b, a % b);
}
```

# 📌 이항계수
***
- nCk = n! / k!(n-k)!
- nCk = n-1Ck-1 + n-1Ck
- 팩토리얼은 12를 넘어가면 int를 벗어나고 20을 넘어가면 long을 벗어난다.

# 📌 Array To String
***
```java
int[] arr = {1,2,3};
String s = Arrays.toString(arr);
// [1,2,3]

String[] arr2 = {"a","b","c"};
String s2 = String.join("", arr);
// abc
        
Arrays.stream(arr2).collect(Collectors.joining());
// abc

String.valueOf(charArr);
// abc
```

# 📌 DeQue
> 앞ㅍ 뒤로 요소를 입 출력 가능, 스택, 큐로 모두 사용할 수 있다. 
```java
Deque<T> deque = new ArrayDeque, LinkedList ..
```
### ✏️ 요소 삽입.
- addFirst, OfferFirst, push : 덱의 앞에 요소 삽입, add는 예외를, offer는 boolean값 반환.
- addList, OfferLast, add : 덱의 뒤에 요소 삽입.
- addAll(Collection ) : collection의 모든 데이터를 덱의 뒤쪽에 삽입.

### ✏️ 요소 제거.
- removeFirst, pollFirst, remove, poll, pop : 앞쪽에서 제거 후 반환, remove는 덱이 비어있으면 예외를, poll은 null을 리턴.
- removeLast, pollLast : 뒤에서 제거하고 반환.
- removeFirstOccurrence(Obj o), remove(Obj o) : 앞쪽에서 부터 탐색하며 o를 찾아 제거.
- removeLastOccurrence(Obj o) : 뒤쪽에서 부터 탐색하며 o를 찾아 제거.

### ✏️ 조회
- getFirst, PeekFirst, peek : 덱의 가장 앞 요소를 반환, 덱이 비어있으면 get은 예외를, peek는 null을 반환.
- getLast, peekLast : 덱의 가장 뒷 요소 반환.
- contain(Obj o) : o가 포함되어 있는지 확인.
- size
- iterator : 덱의 앞쪽부터 순차적으로 실행되는 iterator
- descendingIterator : 뒤쪽부터 순차적으로 실행.
