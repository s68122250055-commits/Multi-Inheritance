## Student Information
-   Name: [พิษณุ คำพิมพ์ปิด]
-   Student ID: [68122250055]
-   Submission Date: [19/02/2026]
- ###  Java สืบทอดหลาย class ไม่ได้เพราะอะไร
 Java สืบทอดหลายคลาส (multiple inheritance of classes) ไม่ได้** เพราะต้องการหลีกเลี่ยงปัญหาความกำกวม (ambiguity) และความซับซ้อนในการจัดการโค้ด โดยเฉพาะปัญหาที่เรียกว่า **Diamond Problem**

ตัวอย่าง

-   Class A มีเมธอด `show()`
    
-   Class B และ Class C สืบทอดจาก A
    
-   Class D ต้องการสืบทอดจากทั้ง B และ C
    

โครงสร้างจะเป็นรูปเพชร (diamond)
ปัญหาคือ  ถ้า B และ C มีการ override เมธอด `show()` ต่างกัน  
แล้ว D เรียก `show()`
จะใช้ของ B หรือ C ทำให้เกิดความกำกวม ทำให้ภาษาออกแบบซับซ้อนขึ้น

### เราใช้ Interface + Composition แทนอย่างไร

เนื่องจากไม่สามารถสืบทอดหลาย class ได้  
เราจึงใช้ 2 ข้อคิดแทน	
RescueRobot implements:

-   Flyable
-   Movable
-   Communicable
-   Detectable

Interface กำหนดสิ่งที่ class ต้องทำ  
แต่ไม่เก็บข้อมูลภายใน

COD  ตัวอย่าง
```java
public class RescueRobot 
    implements Flyable, Movable, Communicable, Detectable
    
```
###  อธิบายการแก้ปัญหา default method ชื่อชนกัน
การชนกันของ **default method** จะเกิดเมื่อ class หนึ่ง `implements` หลาย `interface`  
และแต่ละ interface มี **default method ชื่อเดียวกันและ signature เดียวกัน**

ตัวอย่าง:
```java
interface A {
    default void start() {
        System.out.println("Start from A");
    }
}

interface B {
    default void start() {
        System.out.println("Start from B");
    }
}

class C implements A, B { }
```
วิธีแก้ปัญหา Class ที่ implements ต้อง override method นั้นเองอย่างชัดเจน

ตัวอย่าง:
```java
class C implements A, B {

    @Override
    public void start() {
        A.super.start();   // เลือกใช้ของ A
    }
}
```
หรือสามารถเขียน implementation ใหม่เองได้
```java
@Override
public void start() {
    System.out.println("Custom start implementation");
}
```
