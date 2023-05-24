/* Подумать над структурой класса Ноутбук для магазина техники — выделить поля и методы. Реализовать в Java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, 
отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
“Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объём ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев — сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям. */

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Iterator;

public class Task6 {
    public static void main(String[] args) {
      // Описание ноутбуков (для примера 5 шт.)
      NoteBook noteBook1 = new NoteBook("Sony", "mini", 1111);
      noteBook1.setDiagonal(17);
      noteBook1.setHardDisk(500);
      noteBook1.setOS("Windows");
      noteBook1.setRAM(16);

      NoteBook noteBook2 = new NoteBook("HP", "book", 2222);
      noteBook2.setDiagonal(19);
      noteBook2.setHardDisk(1000);
      noteBook2.setOS("Windows");
      noteBook2.setRAM(32);

      NoteBook noteBook3 = new NoteBook("Dell", "delldell", 3333);
      noteBook3.setDiagonal(21);
      noteBook3.setHardDisk(700);
      noteBook3.setOS("Windows");
      noteBook3.setRAM(64);

      NoteBook noteBook4 = new NoteBook("Asus", "asus", 4444);
      noteBook4.setDiagonal(19);
      noteBook4.setHardDisk(900);
      noteBook4.setOS("Linux");
      noteBook4.setRAM(64);

      NoteBook noteBook5 = new NoteBook("Apple", "apple", 5555);
      noteBook5.setDiagonal(19);
      noteBook5.setHardDisk(1000);
      noteBook5.setOS("MacOS");
      noteBook5.setRAM(64);

      // Поместили, описанные выше ноутбуки, в Set.
      HashSet <NoteBook> books = new HashSet <> (Arrays.asList(noteBook1,noteBook2,noteBook3,noteBook4,noteBook5));

      //Создаем объект класса Мар, в который будем записывать критерии фильтрации, указанные покупателем. 
      Map <String, Object> yourFilter = new HashMap<>();

      //Запрашиаем у покупателя критерии для подбора ноутбука. Записываем в Мар yourFilter 
      Scanner sc = new Scanner(System.in);
      System.out.print("Укажите критерий фильтрации:\n 1 - диагональ \n 2 - оперативная память \n 3 - жесткий диск \n 4 - операционная система \n");
      int filter = sc.nextInt();

      while (filter < 5) {
          if (filter == 1) {
          System.out.println("Укажите мнимальный размер диагонали, дм: ");
          Integer diag = sc.nextInt();
          yourFilter.put("diagonal", diag);
          }
          if (filter == 2) {
            System.out.println("Укажите мнимальный объем оперативной памяти, ГБ: ");
            int ram = sc.nextInt();
            yourFilter.put("RAM", ram);
          }
          if (filter == 3) {
            System.out.println("Укажите мнимальный объем жесткого диска, ТБ: ");
            int hard = sc.nextInt();
            yourFilter.put("hard", hard);
          }
          if (filter == 4) {
            System.out.println("Укажите опреационную систему: ");
            String os = sc.next();
            yourFilter.put("OS", os);
          }

          System.out.print("Укажите критерий фильтрации:\n 1 - диагональ \n 2 - оперативная память \n 3 - жесткий диск \n 4 - операционная система \n");
          filter = sc.nextInt();
      }
      // System.out.println(yourFilter);     
      sc.close();

      //Проходим по каждой паре ключ-значение и проверяем, есть ли ключ из конкретной пары в Мар yourFilter, 
      //т.е. указал ли покупател, данный критерий для подбора ноутбука.
      //Если критерий покупателнм указан, то проходим по всем ноутбукам и сравниваем его характеристики с соответствуюми 
      // критериями, указанными покупателем.     
     for (Map.Entry<String, Object> entry: yourFilter.entrySet()) {
        
        if (entry.getKey().equalsIgnoreCase("RAM")) {
          Iterator <NoteBook> it = books.iterator();
          while (it.hasNext()) {
            NoteBook noteBook = (NoteBook)it.next();
            if (noteBook.getRAM() < (Integer)yourFilter.get("RAM")) {
              it.remove();
            }
          }
        }
          
        if (entry.getKey().equalsIgnoreCase("diagonal")) {
          Iterator <NoteBook> it = books.iterator();
          while (it.hasNext()) {
            NoteBook noteBook = (NoteBook)it.next();
            if (noteBook.getDiagonal() < (Integer)yourFilter.get("diagonal")) {
              it.remove();
            }
          }
        }
     
        if (entry.getKey().equalsIgnoreCase("hard")) {
          Iterator <NoteBook> it = books.iterator();
          while (it.hasNext()) {
            NoteBook noteBook = (NoteBook) it.next();
            if (noteBook.getHardDisk() < (Integer)yourFilter.get("hard")) {
              it.remove();
            }
          }
        }
     
        if (entry.getKey().equalsIgnoreCase("OS")) {
          Iterator <NoteBook> it = books.iterator();
          while (it.hasNext()) {
            NoteBook noteBook = (NoteBook) it.next();
            if (!noteBook.getOS().equalsIgnoreCase((String)yourFilter.get("OS"))) {
              it.remove();
            }
          }
        }
    }

    //Выводи результат поиска.
    Iterator <NoteBook> it = books.iterator();
    while (it.hasNext()) {
      NoteBook noteBook = (NoteBook)it.next();
      System.out.println("Вам подходит: " + noteBook.toString() + "\n");
      // System.out.println();
    }

  }
}
