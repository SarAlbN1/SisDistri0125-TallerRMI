# 📡 Bolsa de Empleo Distribuida (RMI)

Este proyecto implementa una aplicación distribuida usando Java RMI. Permite que empresas registren vacantes y que aspirantes consulten e inscriban a las ofertas disponibles.

---

## 👩‍💻 Autora

**Sara Albarracín**  
Ingeniería de Sistemas  
Pontificia Universidad Javeriana  
Curso: Introducción a los Sistemas Distribuidos

---

## ✨ Funcionalidades

- Registro de ofertas laborales por parte de empresas.
- Consulta de vacantes disponibles por aspirantes.
- Inscripción de aspirantes a vacantes específicas.

---

## 📁 Estructura del Proyecto

```
BolsaEmpleoRMI/
├── interfaz/
│   └── BolsaEmpleo.java
├── servidor/
│   ├── BolsaEmpleoImpl.java
│   └── Servidor.java
├── cliente/
│   ├── ClienteEmpresa.java
│   └── ClienteAspirante.java
├── data/
│   ├── ofertas.txt
│   └── inscripciones.txt
└── README.md
```

---

## ⚙️ Requisitos

- JDK 8 o superior
- Conexión VPN (Hamachi o Tailscale)
- Máquinas con conectividad entre sí
- Sistema Linux (para pruebas y despliegue)

---

## 🔧 Compilación

```console
javac interfaz/BolsaEmpleo.java
javac servidor/BolsaEmpleoImpl.java
rmic servidor.BolsaEmpleoImpl
javac servidor/Servidor.java
javac cliente/ClienteEmpresa.java
javac cliente/ClienteAspirante.java
```

---

## 🚀 Ejecución

### Servidor

```console
cd servidor
rmiregistry &
java Servidor
```

### Cliente Empresa

```console
cd cliente
java ClienteEmpresa
```

### Cliente Aspirante

```console
cd cliente
java ClienteAspirante
```

⚠️ Recuerda reemplazar `localhost` con la IP del servidor si usas varias máquinas.

---

## 📄 Observaciones

- Este proyecto **no utiliza base de datos**, solo archivos planos.
- Para efectos del taller, se debe ejecutar en **al menos tres máquinas distintas** usando una VPN.
- También se puede probar localmente en diferentes terminales.

---

## 📷 Video de entrega

En el video se debe mostrar:
1. Servidor encendido y escuchando.
2. Cliente Empresa registrando una oferta.
3. Cliente Aspirante consultando e inscribiéndose.
4. Archivos de persistencia actualizados (`.txt`).
