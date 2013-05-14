#Git and git repositories

Es una buena idea usar 'Version Control Systems' (Sistemas de Control de Versiones), que guardan copias de todas las versiones de un archivo (bueno, normalmente guardan las diferencias, o deltas, con la version anterior, para ahorrar espacio, pero se pueden conseguir todas las versiones aplicando las deltas). Hay muchos VCSs, pero uno de los mas usados ahora es [`git`](http://git-scm.com/), que es el sistema usado para mantener el codigo fuente de Linux.

Una de las ventajas de usar git es que hay al menos 2 servidores que dan servicio de git gratis; [github.com](http://github.com), que es el mas popular, y proporciona servicios gratis solo si el codigo es abierto al publico (no necesariamente 'Open Source', pero el codigo estara disponible), y [bitbucket.org](http://bitbucket.org), que proporciona servicios gratuitos incluso con codigo cerrado.

## cloning
```
git clone https://you:password@github.com/you/yourRepo
```

## Committing (guardar al repo local)
```
git add .
git commit -am "cambie todo, ya functiona"
```

## Pushing (copiar al server)
```
git push
```

## Pulling (bajar del server)
```
git pull
```
