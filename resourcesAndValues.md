#Android Resources and Values

Android guarda recursos (imagenes, sonidos etc) y valores in XML files, y te permite accesarlos facilmente, y cargar diferentes recursos dependiendo del tama&ntilde;o de pantalla, lenguaje etc

Los recursos tienen que ir en directorios especificos, siempre dentro del directorio `res`. La jerarquia (abreviada) es la siguiente:

* `drawable` para fotos e imagenes
* `layout`	para layouts en xml
* `values`	valores definidos en xml
* `menu` para menus
* `anim`, `animator` animaciones
	
## Valores

Ademas de los recursos mencionados, podemos guardar valores basicos (ints, bools, strings etc) in xml files in the `values` folder, con el nombre del archivo dependiendo del tipo  de datos; por ejemplo, para guardar colores, tendriamos lo siguiente en `values\colors.xml`

```
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="green">#00BB55</color>    
</resources>
```

### Referenciando los valores
En XML referenciamos con @color/xxx (dependiendo del tipo) y en codigo java con R.color.xxx (tambien, dependiendo del tipo)

## Adaptando recursos
