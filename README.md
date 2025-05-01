# 📚 Sistema de Gestión de Biblioteca con POO y Herencia en Java

## 🧾 Introducción

Esta práctica tuvo como objetivo desarrollar un sistema de gestión de biblioteca aplicando **Programación Orientada a Objetos (POO)** y los conceptos de **herencia, polimorfismo y encapsulamiento** en Java. Se simula una biblioteca que permite gestionar préstamos de libros y revistas usando clases, herencia, métodos sobrescritos y control de flujo.

Además, se integraron herramientas como **GitHub** (para el control de versiones) y **Microsoft Planner** (para organizar tareas), reforzando la estructura de un desarrollo colaborativo y planificado.

---

### 🧱 Estructura del Código y explicación de cada clase

| Clase                   | Tipo de clase  | Uso principal                                                                 |
|------------------------|----------------|-------------------------------------------------------------------------------|
| `RecursoBibliografico` | Abstracta       | Define atributos comunes y el método abstracto `mostrarDetalle()`             |
| `Libro`                | Hija            | Hereda de `RecursoBibliografico`, añade `autor` y `prestado`, sobrescribe `mostrarDetalle()` |
| `Revista`              | Hija            | Hereda de `RecursoBibliografico`, añade `anioPublicacion` y `ejemplares`     |
| `Usuario`              | Concreta        | Administra préstamos y devoluciones de recursos                              |
| `Main`                 | Ejecutable      | Contiene el menú y controla la interacción entre usuario y recursos          |

---

## 📘 Explicación de Clases

### 🔷 `RecursoBibliografico` (Clase abstracta)
Esta clase se usa como **base general** para todos los recursos de la biblioteca (libros y revistas). Tiene atributos `titulo` e `id`, comunes a todos, y un método abstracto `mostrarDetalle()` que obliga a las subclases a implementar su propia versión.

```java
public abstract class RecursoBibliografico {
    protected String titulo;
    protected String id;
    public abstract void mostrarDetalle();
}
```

---

### 📕 `Libro` (Subclase de RecursoBibliografico)
Extiende la clase `RecursoBibliografico` usando `extends`. Añade el atributo `autor` y un booleano `prestado` para saber si está disponible. Sobrescribe `mostrarDetalle()` para mostrar datos específicos del libro.

```java
public class Libro extends RecursoBibliografico {
    private String autor;
    private boolean prestado;

    @Override
    public void mostrarDetalle() {
        System.out.println("Libro: " + titulo + " | Autor: " + autor + " | ID: " + id + " | Prestado: " + prestado);
    }
}
```

---

### 📗 `Revista` (Subclase de RecursoBibliografico)
También extiende la clase base. Añade atributos específicos: `anioPublicacion` y `ejemplares`. No necesita validar préstamo, pero muestra sus datos con su propia versión de `mostrarDetalle()`.

```java
public class Revista extends RecursoBibliografico {
    private int anioPublicacion;
    private int ejemplares;

    @Override
    public void mostrarDetalle() {
        System.out.println("Revista: " + titulo + " | Año: " + anioPublicacion + " | Ejemplares: " + ejemplares);
    }
}
```

---

### 👤 `Usuario`
Permite que una persona pueda prestar y devolver recursos. Usa una lista para registrar los recursos prestados.

```java
public class Usuario {
    private String nombre;
    private List<RecursoBibliografico> recursosPrestados;

    public void prestarRecurso(RecursoBibliografico recurso) { ... }
    public void devolverRecurso(RecursoBibliografico recurso) { ... }
}
```

---

### 🎮 `Main`
Clase principal que contiene el menú con `Scanner`. Permite ver recursos disponibles, prestar y devolver. Es el punto de entrada del programa.

---

## 🧬 ¿Cómo se aplicó la Herencia?

La herencia se utilizó para evitar repetir código común (como `titulo` e `id`) y permitir que tanto `Libro` como `Revista` se comporten como `RecursoBibliografico`.  
Esto hace que el código sea más limpio y fácil de mantener. Usamos `extends` en:

```java
public class Libro extends RecursoBibliografico { ... }
```

---

## 🌀 ¿Cómo se aplicó el Polimorfismo?

El polimorfismo se ve cuando usamos:

```java
List<RecursoBibliografico> recursos = new ArrayList<>();
```

Y aunque la lista es del tipo general `RecursoBibliografico`, al llamar `recurso.mostrarDetalle()` en cada objeto, **Java llama automáticamente a la versión correcta** dependiendo si es un `Libro` o una `Revista`.

---

## 🧠 Resolución de Problemas

- ✅ Dificultad inicial al usar polimorfismo → solucionado con métodos sobrescritos
- ✅ Validación de préstamo repetido → resuelto con `isPrestado()`
- ✅ Estructura en VS Code → se organizaron clases por temas y carpetas

---

## 🔚 Conclusión General

Este proyecto fortaleció el uso de los pilares de la POO en un ejemplo práctico y realista. Usamos:

- **Herencia** para evitar repetir código y facilitar la organización
- **Polimorfismo** para manejar distintos tipos de recursos con un mismo método
- **Encapsulamiento** para proteger los datos de cada clase

Además, aprendimos a compilar desde terminal, organizar un proyecto Java profesional y documentar correctamente usando Markdown.  
Esta práctica es un gran paso hacia el desarrollo de aplicaciones más grandes, limpias y escalables.

---
