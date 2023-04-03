# MIW__MDW__intervals

## Nota sobre los test de Interval.hasIntersection


Tenemos los siguientes casos posibles dado un intervalo, que en el dibujo
pintamos abierto-abierto, pero puede ser cualquier combinación

```
----------------|(------------)|-------------------------------------
----------------|--------------|-----(---)--------------------------- 1
----------------|--------------|(---)-------------------------------- 2
----------------|------------(-|-)----------------------------------- 3
----------------|----(---)-----|------------------------------------- 4
--------------(-|-)------------|------------------------------------- 5
------------(--)|--------------|------------------------------------- 6
--------(---)---|--------------|------------------------------------- 7
--------------(-|--------------|-)----------------------------------- 8
----------------|-----(-------)|------------------------------------- 9
--------------(-|-------------)|------------------------------------- 10
----------------|(----)--------|------------------------------------- 11
----------------|(-------------|-)----------------------------------- 12
----------------|(------------)|------------------------------------- 13
```

Tenemos que el intervalo que recibe el mensaje puede ser de 4 tipos:
OO, CO, OC, CC. Y el intervalo parámetro también puede ser de esos 4
tipos, tenemos pues `4 * 4 * 13 = 208` casos  
(`52` casos por cada tipo de intervalo que reciba el mensaje)

Independientemente de como sean los intervalos hay casos que siempre
van a dar el mismo resultado:

1, 7 siempre va a dar false  
3, 4, 5, 8-13 siempre van a dar true

Y los que pueden cambiar son, por tanto: 2 6  

Es decir, para cada combinación de intervalos hay 2 casos particulares y 11 comunes)

Para los 11 comunes se usa el método `provideCommonIntervals` y para los otros dos uno
particular para cada tipo de intervalo que reciba el mensaje: `provideIntervalsForOpenOpen`, 
`provideIntervalsForClosedOpen`, `provideIntervalsForOpenClosed` y `provideIntervalsForClosedClosed`.
