# Tarea para AD04.
## Detalles de la tarea de esta unidad.
En BK ha llegado la hora de conectar con una base de datos relacional para extraer información contenida en objetos de programas que se almacenaron hace algún tiempo.

Para ello, lo primero que tendrás que hacer es tener instalados en tu ordenador el entorno de desarrollo NetBeans y proceder al uso de Hibernate.

En el siguiente enlace accederás a la página web de Oracle, con un ejemplo de uso de Hibernate con NetBeans:

Uso de Hibernate en Netbeans.

Tomando como referencia el proyecto de ejemplo, realiza un proyecto Java en NetBeans que cumpla realice los siguientes pasos:

**Actualmente tengo funcionando un servidor mysql en un servidor, por lo que no fue necesario instarlarlo en local.**
![image](https://user-images.githubusercontent.com/44543081/53835984-119ebe00-3f8f-11e9-8d48-74686810b18a.png)  
*Creo la conexión*  
  
![image](https://user-images.githubusercontent.com/44543081/53836013-28451500-3f8f-11e9-85e1-ad9ca2c205f8.png)  
*Establezco los parámetros de conexión*  
  
![image](https://user-images.githubusercontent.com/44543081/53836137-8245da80-3f8f-11e9-90a0-a649f7f65106.png)  
*Instalo el plugin de sakila*
  
![image](https://user-images.githubusercontent.com/44543081/53836196-9e497c00-3f8f-11e9-9734-cc01cd0560e9.png)  
*Creo una nueva base de datos*  
  
![image](https://user-images.githubusercontent.com/44543081/53836230-bb7e4a80-3f8f-11e9-9117-189f3ce433ef.png)  
*Genero la base de datos usando el plugin*  

![image](https://user-images.githubusercontent.com/44543081/53836277-dcdf3680-3f8f-11e9-9d51-cd441c13fd79.png)  
*Me aseguro de tener instalado el plugin de Hibernate*  
  

![image](https://user-images.githubusercontent.com/44543081/53836316-fe402280-3f8f-11e9-8755-9b30fe929f95.png)  
*Creo un archivo de configuración de Hibernate*  
  
  
![image](https://user-images.githubusercontent.com/44543081/53836582-a7871880-3f90-11e9-9e09-c085d0138b38.png)  
*Compruebo las librerías*  
  
![image](https://user-images.githubusercontent.com/44543081/53836399-32b3de80-3f90-11e9-887b-6c6993823040.png)  
*Configuro los parámetros*  
  
![image](https://user-images.githubusercontent.com/44543081/53836512-7b6b9780-3f90-11e9-9051-9f3bd4024510.png)  
*Utilizo el asistente de archivos de ingeniería inversa de Hibernate para poder acceder a la tabla film de la base de datos*
  
![image](https://user-images.githubusercontent.com/44543081/53836701-efa63b00-3f90-11e9-9976-356ddcaa208e.png)  
*Diseño un frame para realizar las consultas*  

```Java
private static String CONSULTA_BASADA_EN_TITULO="from Film a where a.title like '";
private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {                                         
    // TODO add your handling code here:
    ejecutaConsultaBasadaEnTitulo();
}  

```  
*Almaceno un String con parte del código de consulta y creo el actionPerformed del botón buscar*
```Java
private void ejecutaHQLConsulta (String hql){
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    Query consulta = session.createQuery(hql);
    List resultList = consulta.list();
    mostrarResultados (resultList);
    session.getTransaction().commit();
}
```
*Genero el código que creará la conexión y realizará la consulta*
```Java
private void mostrarResultados(List resultList){
    Vector<String> tableHeaders = new Vector<String>();
    Vector tableData = new Vector();
    tableHeaders.add("Título");
    tableHeaders.add("Año");
    tableHeaders.add("Rating");
    for (Object o :resultList){
        Film film = (Film) o;
        Vector <Object> oneRow = new Vector<Object>();
        oneRow.add(film.getTitle());
        oneRow.add(film.getReleaseYear());
        oneRow.add(film.getRating());
        tableData.add(oneRow);
    }
    tbResultados.setModel(new DefaultTableModel(tableData, tableHeaders));
}
```
*Creo el método para introducir el resultado en la tabla*
  
![image](https://user-images.githubusercontent.com/44543081/53837277-84f5ff00-3f92-11e9-8961-317315476640.png)  
*Muestro funcionamiento*
