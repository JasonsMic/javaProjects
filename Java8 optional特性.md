### Java8 optional 常用特性

##### 一. lambda 表达式

> java8 发布于2014年，相比于java7，java8新增了很多特性，比如lambda函数式接口、f方法引用、默认方法、Date Time Api、streamApi、optional等。lambda表达式又称闭包或匿名函数，主要优点在于简化代码、增强代码可读性、并行操作集合等。
>

- 基本语法

  ```
   (parameters) -> expression
   or
   (parameters) ->{ statements; }
  ```

- lambda表达式特性

  1. **可选类型声明**:  无需声明参数类型，编译器即可自动识别
  2. **可选的参数圆括号**: 仅有一个参数时圆括号可以省略
  3. **可选的大括号**：主体只包含一个语句时可省略大括号
  4. **可选的返回关键字**：主体只包含一个表达式返回值并省略大括号时，编译器会自动return返回值；有大括号时，需要显式指定表达式return了一个数值

- 特性示例:

  ```java
  示例:
  //1、无参数，返回值1
  () -> 1 
  //2、无参数，无返回值
  () -> System.out.print("J8 lambda");
  //3、1个参数，参数类型为数字，返回值为其值的5倍
  x ->  5 * x 
  //4、2个参数，参数类型均为数字，返回值为其差值
  (x, y) -> x - y
  //5、2个参数，指定参数类型均为int型，返回值为其差值 
  (int x, int y) -> x - y  
  //6、1个参数，指定参数类型为String ，无返回值
  (String str) -> System.out.print(str)
  ```







##### 二.  Optional 简介

> Optional类是Java8为了解决null值判断问题，借鉴google guava类库的Optional类而引入的一个同名Optional类，使用Optional类可以避免显式的null值判断（null的防御性检查），避免null导致NPE（NullPointerException）。

- 代码示例

  1. 未使用optional

     ```java
     // 获取系统用户名的方法，方法入参为一个SysUser实例，为了防止user对象为null，做了防御性检查：如果为null，返回"Unkown"，
     public static String getUserName(SysUser user)
         {
             if(null == user)
             {
                 return "Unkown";
             }
             return user.getUserName();
         }
     ```

  2. 使用optional优化后

     ```java
     public static String getUserName(SysUser user){
         return Optional.ofNullable(user).map(u -> u.getUserName).orElse("Unkown");
     }
     ```

     

##### 三.  Optional对象的创建

- Optional部分源码

  ```java
      private static final Optional<?> EMPTY = new Optional<>();
  
      private final T value;
  
      private Optional() {
          this.value = null;
      }
  
      public static<T> Optional<T> empty() {
          @SuppressWarnings("unchecked")
          Optional<T> t = (Optional<T>) EMPTY;
          return t;
      }
  
      private Optional(T value) {
          this.value = Objects.requireNonNull(value);
      }
  
      public static <T> Optional<T> of(T value) {
          return new Optional<>(value);
      }
  
      public static <T> Optional<T> ofNullable(T value) {
          return value == null ? empty() : of(value);
      }
  ```

- 从源码中可以看出，Optional类的两个构造方法都是private型的，因此类外部不能显示的使用new Optional()的方式来创建Optional对象，但是Optional类提供了三个静态方法empty()、of(T value)、ofNullable(T value)来创建Optinal对象，示例如下：

  ```java
  // 1、创建一个包装对象值为空的Optional对象
  Optional<String> optStr = Optional.empty();
  // 2、创建包装对象值非空的Optional对象
  Optional<String> optStr1 = Optional.of("optional");
  // 3、创建包装对象值允许为空的Optional对象
  Optional<String> optStr2 = Optional.ofNullable(null);
  ```

  







##### 四.  类典型接口的使用

> Optinal API常用接口的用法

1. get() 方法

   ```java
   // 要用于返回包装对象的实际值，但是如果包装对象值为null，会抛出NoSuchElementException异常
   public T get() {
       if (value == null) {
           throw new NoSuchElementException("No value present");
       }
       return value;
   }
   ```

2. isPresent() 方法

   ```java
   // 判断包装对象的值是否为空
   public boolean isPresent() {
       return value != null;
   }
   ```

3. ifPresent() 方法

   ```java
   //接受一个Consumer对象（消费函数），如果包装对象的值非空，运行Consumer对象的accept()方法。
   public void ifPresent(Consumer<? super T> consumer) {
       if (value != null)
          consumer.accept(value);
   }
   // 示例 
   public static void printName(SYsUser user){
           Optional.ofNullable(user).ifPresent(u ->  
                System.out.println("The user name is : " +       u.getName()));
   }
   ```

   

4. filter() 方法

   ```java
   // filter()方法接受参数为Predicate对象，用于对Optional对象进行过滤，如果符合Predicate的条件，返回 //Optional对象本身，否则返回一个空的Optional对象
   public Optional<T> filter(Predicate<? super T> predicate) {
       Objects.requireNonNull(predicate);
       if (!isPresent())
          return this;
       else
          return predicate.test(value) ? this : empty();
   }
   
   // 示例 校验当前用户年龄是否大于18岁
   public static void filterAge(SysUser user){
           Optional.ofNullable(user).filter( u -> u.getAge() > 18).ifPresent(u ->  System.out.println("The user age is more than 18."));
   }
   ```

   

5. map() 方法

   ```java
   // 参数为Function（函数式接口）对象，map()方法将Optional中的包装对象用Function函数进行运算,
   // 并包装成新的Optional对象（包装对象的类型可能改变)
   public<U> Optional<U> map(Function<? super T, ? extends U> mapper) {
       Objects.requireNonNull(mapper);
       if (!isPresent())
           return empty();
       else {
           return Optional.ofNullable(mapper.apply(value));
       }
   }
   
   // 示例
   // 用ofNullable()方法构造一个Optional<SysUser>对象，
   // 然后用map()计算用户的年龄，返回Optional<Integer>对象（如果user为null, 
   // 返回map()方法返回一个空的Optinal对象）
   public static Optional<Integer> getAge(SysUser user){
       return Optional.ofNullable(user).map(u -> u.getAge()); 
   }
   ```

   

6. flatMap() 方法

   ```java
   // map()方法不同的是，入参Function函数的返回值类型为Optional<U>类型，而不是U类型，
   // flatMap()能将一个二维的Optional对象映射成一个一维的对象。
   public<U> Optional<U> flatMap(Function<? super T, Optional<U>> mapper) {
       Objects.requireNonNull(mapper);
       if (!isPresent())
           return empty();
       else {
           return Objects.requireNonNull(mapper.apply(value));
       }
   }
   // 示例
    public static Optional<Integer> getAge(SysUser user){
        return Optional.ofNullable(user).flatMap(u -> Optional.ofNullable(u.getAge())); 
    }
   ```

   

7. orElse() 方法

   ```java
   //包装对象值非空，返回包装对象值，否则返回入参other的值（默认值）
   public T orElse(T other) {
           return value != null ? value : other;
    }
   // 示例
    public static String getGender(SysUser user) {
      return Optional.ofNullable(user).map(u -> u.getGender()).orElse("Unkown");       
    }
   ```

   

8. orElseGet() 方法

   ```java
   // orElseGet()方法与orElse()方法类似，区别在于orElseGet()方法的入参为一个Supplier对象.
   // 用Supplier对象的get()方法的返回值作为默认值。
   public T orElseGet(Supplier<? extends T> other) {
       return value != null ? value : other.get();
   }
   
   // 示例
   public static String getGender(SysUser user){
       return Optional.ofNullable(user).map(u -> u.getGender()).orElseGet(() -> "Unkown");      
   }
   ```

   

9. orElseThrow() 方法

   ````java
    // https://www.jianshu.com/p/d81a5f7c9c4e
    public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
           if (value != null) {
               return value;
           } else {
               throw exceptionSupplier.get();
           }
       }
   ````

   

##### 五.  注意事项

> 使用Optional开发时要注意正确使用Optional的“姿势”，谨慎使用isPresent()和get()方法，尽量多使用map()、filter()、orElse()等方法来发挥Optional的作用。