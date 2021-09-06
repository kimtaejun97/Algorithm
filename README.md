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



# 📌 Matchees, Pattern
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