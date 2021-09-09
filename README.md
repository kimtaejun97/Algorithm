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

# 📌 Stream, reduce와 matToInt
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


### 🧐 getOrDefaultm
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
- add
    - 다른 리스트에 넣어 두었다가 순회가 끝난 후 addAll
```

- Iterator를 사용하고, remove할 때에는 iterator 자체를 remove해서 제거해준다.

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
