# SI_2024_lab2_225048
Ivan Perchuklieski 225048


3. Цикломатската комплексност е 8, ја добив со додавање 1 на бројот на предикатни јазли што е 7 => 7 + 1 = 8

4. - Ако allItems е null имаме allItems list can't be null! exception 
   - Ако има ненумерички караткер во баркодот имаме Invalid character in item barcode! exception
   - Ако нема баркод има No barcode! exception
   - Ако се е во ред, на крај можеме да имаме True или False во зависнот од тоа дали сумата е поголема од платеното или не
  
5. (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0')
   - T && T && T : Ако цената е поголема од 300, има попуст и баркодот започнува со 0
   - F && X && X : Ако цената е помала од 300 другите две не е битно на што се еднакви
   - T && F && X : Ако цената е поголема од 300, а нема попуст, баркодот не е битен
   - T && T && F : Ако цената е 300, има попуст, баркодот не започнува со 0
