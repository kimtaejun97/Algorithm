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



# 📌 Matcher, Pattern
****
