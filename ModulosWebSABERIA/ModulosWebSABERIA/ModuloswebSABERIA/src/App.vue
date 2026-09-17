<template>
  <div class="app">

    <!-- =========================
         LOGIN
    ========================== -->
    <section v-if="vista === 'login'" class="login-page">

      <div class="login-card">

        <div class="logo">
          <div class="logo-circle">S</div>
          <h1>SABERIA</h1>
        </div>

        <p class="subtitle">
          Plataforma de aprendizaje y refuerzo educativo
        </p>

        <div class="form-group">
          <label>Usuario</label>
          <input
            v-model="usuario"
            type="text"
            placeholder="Ingresa tu usuario"
          />
        </div>

        <div class="form-group">
          <label>Contraseña</label>
          <input
            v-model="contrasena"
            type="password"
            placeholder="Ingresa tu contraseña"
          />
        </div>

        <button class="login-button" @click="iniciarSesion">
          Ingresar
        </button>

        <p v-if="error" class="error">
          {{ error }}
        </p>

        <p class="login-info">
          Aprende, practica y supera nuevos retos 🚀
        </p>

      </div>

    </section>

    <section v-else-if="vista === 'dashboard'" class="dashboard">

      <!-- BARRA SUPERIOR -->
      <header class="navbar">

        <div class="brand">
          <div class="brand-icon">S</div>
          <span>SABERIA</span>
        </div>

        <div class="user-area">
          <span>Hola, {{ usuario || 'Estudiante' }} 👋</span>

          <button class="logout-button" @click="cerrarSesion">
            Cerrar sesión
          </button>
        </div>

      </header>


      <!-- CONTENIDO PRINCIPAL -->
      <main class="main-content">

        <div class="welcome">
          <h1>¡Bienvenido a SABERIA! 🎓</h1>

          <p>
            Explora las islas de conocimiento y fortalece tus habilidades.
          </p>
        </div>

        <!-- INFORMACIÓN DEL ESTUDIANTE -->
        <div class="student-card">

          <div class="student-avatar">
            {{ usuario ? usuario.charAt(0).toUpperCase() : 'E' }}
          </div>

          <div class="student-info">
            <h2>{{ usuario || 'Estudiante' }}</h2>
            <p>Nivel actual: <strong>{{ nivelGeneral }}</strong></p>
          </div>

          <div class="progress-info">
            <span>Progreso general</span>

            <div class="progress-bar">
              <div
                class="progress-fill"
                :style="{ width: progresoGeneral + '%' }"
              ></div>
            </div>

            <strong>{{ progresoGeneral }}%</strong>
          </div>

             <div class="points-card">
            <span>⭐ Puntos</span>
            <strong>{{ puntos }}</strong>
          </div>

        </div>

        


        <!-- TÍTULO DE ISLAS -->
        <div class="section-title">
          <h2>🏝️ Islas de conocimiento</h2>

          <p>
            Selecciona una asignatura para comenzar.
          </p>
        </div>


        <!-- =========================
             ISLAS
        ========================== -->
        <div class="islands">

          <!-- MATEMÁTICAS -->
          <div class="island math">

            <div class="island-icon">
              🔢
            </div>

            <div class="island-content">

              <h2>Matemáticas</h2>

              <p>
                Aprende números, operaciones y resolución de problemas.
              </p>

              <div class="level">
                <span>Nivel</span>
                <strong>{{ niveles.matematicas }}</strong>
              </div>

              <div class="island-progress">
                <div
                  :style="{ width: progreso.matematicas + '%' }"
                ></div>
              </div>

              <span class="progress-text">
                {{ progreso.matematicas }}% completado
              </span>

              <button
                class="island-button"
                @click="seleccionarMateria('Matemáticas')"
              >
                Comenzar
              </button>

            </div>

          </div>


          <!-- LENGUAJE -->
          <div class="island language">

            <div class="island-icon">
              📚
            </div>

            <div class="island-content">

              <h2>Lenguaje</h2>

              <p>
                Fortalece tu lectura, escritura y comprensión.
              </p>

              <div class="level">
                <span>Nivel</span>
                <strong>{{ niveles.lenguaje }}</strong>
              </div>

              <div class="island-progress">
                <div
                  :style="{ width: progreso.lenguaje + '%' }"
                ></div>
              </div>

              <span class="progress-text">
                {{ progreso.lenguaje }}% completado
              </span>

              <button
                class="island-button"
                @click="seleccionarMateria('Lenguaje')"
              >
                Comenzar
              </button>

            </div>

          </div>


          <!-- CIENCIAS -->
          <div class="island science">

            <div class="island-icon">
              🔬
            </div>

            <div class="island-content">

              <h2>Ciencias</h2>

              <p>
                Descubre el mundo de la ciencia y la naturaleza.
              </p>

              <div class="level">
                <span>Nivel</span>
                <strong>{{ niveles.ciencias }}</strong>
              </div>

              <div class="island-progress">
                <div
                  :style="{ width: progreso.ciencias + '%' }"
                ></div>
              </div>

              <span class="progress-text">
                {{ progreso.ciencias }}% completado
              </span>

              <button
                class="island-button"
                @click="seleccionarMateria('Ciencias')"
              >
                Comenzar
              </button>

            </div>

          </div>


          <!-- SOCIALES -->
          <div class="island social">

            <div class="island-icon">
              🌎
            </div>

            <div class="island-content">

              <h2>Ciencias Sociales</h2>

              <p>
                Conoce la historia, la sociedad y nuestro mundo.
              </p>

              <div class="level">
                <span>Nivel</span>
                <strong>{{ niveles.sociales }}</strong>
              </div>

              <div class="island-progress">
                <div
                  :style="{ width: progreso.sociales + '%' }"
                ></div>
              </div>

              <span class="progress-text">
                {{ progreso.sociales }}% completado
              </span>

              <button
                class="island-button"
                @click="seleccionarMateria('Ciencias Sociales')"
              >
                Comenzar
              </button>

            </div>

          </div>


          <!-- INGLÉS -->
          <div class="island english">

            <div class="island-icon">
              🇬🇧
            </div>

            <div class="island-content">

              <h2>Inglés</h2>

              <p>
                Practica vocabulario, comprensión y comunicación.
              </p>

              <div class="level">
                <span>Nivel</span>
                <strong>{{ niveles.ingles }}</strong>
              </div>

              <div class="island-progress">
                <div
                  :style="{ width: progreso.ingles + '%' }"
                ></div>
              </div>

              <span class="progress-text">
                {{ progreso.ingles }}% completado
              </span>

              <button
                class="island-button"
                @click="seleccionarMateria('Inglés')"
              >
                Comenzar
              </button>

            </div>

          </div>


          <!-- TECNOLOGÍA -->
          <div class="island technology">

            <div class="island-icon">
              💻
            </div>

            <div class="island-content">

              <h2>Tecnología</h2>

              <p>
                Aprende sobre tecnología, informática y herramientas digitales.
              </p>

              <div class="level">
                <span>Nivel</span>
                <strong>{{ niveles.tecnologia }}</strong>
              </div>

              <div class="island-progress">
                <div
                  :style="{ width: progreso.tecnologia + '%' }"
                ></div>
              </div>

              <span class="progress-text">
                {{ progreso.tecnologia }}% completado
              </span>

              <button
                class="island-button"
                @click="seleccionarMateria('Tecnología')"
              >
                Comenzar
              </button>

            </div>

          </div>

        </div>


        <!-- =========================
             RETOS
        ========================== -->
        <section class="challenge-section">

          <div class="challenge-card">

            <div class="challenge-icon">
              🏆
            </div>

            <div>
              <h2>¡Tu próximo reto te espera!</h2>

              <p>
                Completa actividades y gana puntos para avanzar de nivel.
              </p>
            </div>

            <button
              class="challenge-button"
              @click="mostrarMensaje"
            >
              Ver retos
            </button>

          </div>

        </section>

      </main>

      <!-- FOOTER -->
      <footer class="footer">
        <p>
          © 2026 SABERIA - Plataforma educativa
        </p>
      </footer>

    </section>


    <!-- =========================
         MODAL
    ========================== -->
    <div v-if="materiaSeleccionada && vista !== 'actividad'" class="modal-background">

      <div class="modal">

        <button
          class="close-modal"
          @click="materiaSeleccionada = ''"
        >
          ×
        </button>

        <div class="modal-icon">
          🎯
        </div>

        <h2>{{ materiaSeleccionada }}</h2>

        <p>
          ¡Excelente elección!
        </p>

        <p class="modal-text">
          Aquí podrás realizar actividades, responder preguntas
          y avanzar en tu nivel de aprendizaje.
        </p>

        <div class="modal-level">
          Nivel actual:
          <strong>{{ obtenerNivel(materiaSeleccionada) }}</strong>
        </div>

        <button
          class="start-button"
          @click="comenzarActividad"
        >
          Comenzar actividad
        </button>

      </div>
    </div>
<!-- =========================
     ACTIVIDAD
========================== -->
<section v-if="vista === 'actividad'" class="activity-page"> 

  <div class="activity-card">
<!-- MATEMÁTICAS -->
<div v-if="materiaSeleccionada === 'Matemáticas'">

  <div class="activity-icon">
    🔢
  </div>

  <h1>Actividad de Matemáticas</h1>

  <p class="activity-subtitle">
    Nivel 1 · Operaciones básicas
  </p>

  <div class="question-box">

    <h2>¿Cuánto es 8 + 4?</h2>

    <div class="answers">

      <button @click="responder(10)">
        10
      </button>

      <button @click="responder(12)">
        12
      </button>

      <button @click="responder(14)">
        14
      </button>

      <button @click="responder(16)">
        16
      </button>

    </div>

  </div>

</div>


<!-- LENGUAJE -->
<div v-if="materiaSeleccionada === 'Lenguaje'">

  <div class="activity-icon">
    📚
  </div>

  <h1>Actividad de Lenguaje</h1>

  <p class="activity-subtitle">
    Nivel 1 · Comprensión y escritura
  </p>

  <div class="question-box">

    <h2>¿Cuál oración está escrita correctamente?</h2>

    <div class="answers">

      <button @click="responderLenguaje('A')">
        A) Mi perro corre en el parque.
      </button>

      <button @click="responderLenguaje('B')">
        B) mi perro corre en el parque.
      </button>

      <button @click="responderLenguaje('C')">
        C) Mi perro corre en El parque.
      </button>

      <button @click="responderLenguaje('D')">
        D) mi Perro corre en el parque.
      </button>

    </div>

  </div>

</div>

<!-- =========================
     CIENCIAS
========================== -->

<div v-if="materiaSeleccionada === 'Ciencias'">

  <div class="activity-icon">
    🔬
  </div>

  <h1>Actividad de Ciencias</h1>

  <p class="activity-subtitle">
    Nivel 1 · Ciencias Naturales
  </p>

  <div class="question-box">


<h2>¿Cuántos huesos tiene aproximadamente el cuerpo humano adulto?</h2>

<div class="answers">

 <button type="button" @click="responderCiencias('A')">
  A) 106
</button>

<button type="button" @click="responderCiencias('B')">
  B) 206
</button>

<button type="button" @click="responderCiencias('C')">
  C) 306
</button>

<button type="button" @click="responderCiencias('D')">
  D) 406

</button>
</div>
 </div>
  </div>

  <!-- =========================
     CIENCIAS SOCIALES
========================== -->

<div v-if="materiaSeleccionada === 'Ciencias Sociales'">

  <div class="activity-icon">
    🌎
  </div>

  <h1>Actividad de Ciencias Sociales</h1>

  <p class="activity-subtitle">
    Nivel 1 · Continentes
  </p>

  <div class="question-box">

    <h2>¿Cuál es el continente más grande del mundo?</h2>

    <div class="answers">

      <button type="button" @click="responderSociales('A')">
        A) África
      </button>

      <button type="button" @click="responderSociales('B')">
        B) Europa
      </button>

      <button type="button" @click="responderSociales('C')">
        C) Asia
      </button>

      <button type="button" @click="responderSociales('D')">
        D) Oceanía
      </button>

    </div>
  </div>
</div>

<!-- =========================
     INGLÉS
========================== -->

<div v-if="materiaSeleccionada === 'Inglés'">

  <div class="activity-icon">
    🔤
  </div>

  <h1>Actividad de Inglés</h1>

  <p class="activity-subtitle">
    Nivel 1 · Traducción
  </p>

  <div class="question-box">

    <h2>¿Qué significa la palabra "House"?</h2>

    <div class="answers">

      <button type="button" @click="responderIngles('A')">
        A) Escuela
      </button>

      <button type="button" @click="responderIngles('B')">
        B) Casa
      </button>

      <button type="button" @click="responderIngles('C')">
        C) Comida
      </button>

      <button type="button" @click="responderIngles('D')">
        D) Perro
      </button>

    </div>
  </div>
</div>
 <!-- =========================
     TECNOLOGÍA
========================== -->

<div v-if="materiaSeleccionada === 'Tecnología'">

  <div class="activity-icon">
    💻
  </div>

  <h1>Actividad de Tecnología</h1>

  <p class="activity-subtitle">
    Nivel 1 · Informática
  </p>

  <div class="question-box">

    <h2>¿Para qué sirve un teclado?</h2>

    <div class="answers">

      <button type="button" @click="responderTecnologia('A')">
        A) Para imprimir documentos
      </button>

      <button type="button" @click="responderTecnologia('B')">
        B) Para escribir e introducir información
      </button>

      <button type="button" @click="responderTecnologia('C')">
        C) Para escuchar música
      </button>

      <button type="button" @click="responderTecnologia('D')">
        D) Para tomar fotografías
      </button>

    </div>
  </div>
</div>

  <!-- RESULTADO -->
<p v-if="resultado" class="result">
  {{ resultado }}
</p>

<!-- VOLVER -->
<button
  class="back-button"
  @click="vista = 'dashboard'; resultado = ''; materiaSeleccionada = ''"
>
  ← Volver a las asignaturas
</button>
</div>

</section>


<!-- MENSAJE -->
    <div v-if="mensaje" class="toast">
      {{ mensaje }}
    </div>
  </div>

</template>
<script setup>

import { ref, computed } from 'vue'


/* =========================
   VARIABLES
========================== */

const vista = ref('login')

const usuario = ref('')

const contrasena = ref('')

const error = ref('')

const materiaSeleccionada = ref('')

const mensaje = ref('')
const actividad = ref('')
const resultado =ref ('')
const puntos =ref(0)


/* =========================
   NIVELES
========================== */

const niveles = ref({

  matematicas: 1,

  lenguaje: 1,

  ciencias: 1,

  sociales: 1,

  ingles: 1,

  tecnologia: 1

})


/* =========================
   PROGRESO
========================== */

const progreso = {

  matematicas: 45,

  lenguaje: 30,

  ciencias: 25,

  sociales: 40,

  ingles: 20,

  tecnologia: 35

}


/* =========================
   PROGRESO GENERAL
========================== */

const progresoGeneral = computed(() => {

  const valores = Object.values(progreso)

  const suma = valores.reduce(
    (total, valor) => total + valor,
    0
  )

  return Math.round(suma / valores.length)

})


/* =========================
   NIVEL GENERAL
========================== */

const nivelGeneral = computed(() => {

  const valores = Object.values(niveles.value)

  const suma = valores.reduce(
    (total, valor) => total + valor,
    0
  )

  return Math.round(suma / valores.length)

})


/* =========================
   INICIAR SESIÓN
========================== */

function iniciarSesion() {

  error.value = ''

  if (
    usuario.value.trim() === '' ||
    contrasena.value.trim() === ''
  ) {

    error.value =
      'Por favor, completa todos los campos.'

    return

  }

  vista.value = 'dashboard'

}


/* =========================
   CERRAR SESIÓN
========================== */

function cerrarSesion() {

  vista.value = 'login'

  usuario.value = ''

  contrasena.value = ''

  error.value = ''

}


/* =========================
   SELECCIONAR MATERIA
========================== */

function seleccionarMateria(materia) {

  materiaSeleccionada.value = materia

}


/* =========================
   OBTENER NIVEL
========================== */

function obtenerNivel(materia) {

  const nivelesMateria = {

    'Matemáticas':
      niveles.value.matematicas,

    'Lenguaje':
      niveles.value.lenguaje,

    'Ciencias':
      niveles.value.ciencias,

    'Ciencias Sociales':
      niveles.value.sociales,

    'Inglés':
      niveles.value.ingles,

    'Tecnología':
      niveles.value.tecnologia

  }

  return nivelesMateria[materia] || 1

}


/* =========================
   ACTIVIDAD
========================== */
function comenzarActividad() {

  vista.value = 'actividad'

  resultado.value = ''

}
function responder(respuesta) {

  if (respuesta === 12) {
    puntos.value +=10
    resultado.value =
      '🎉 ¡Correcto! Ganaste 10 puntos en Matemáticas.'

  } else {

    resultado.value =
      '❌ Incorrecto. Intenta nuevamente.'

  }
}
function responderLenguaje(respuesta) {

  if (respuesta === 'A') {
    puntos.value +=10
    resultado.value =
      '🎉 ¡Correcto! Ganaste 10 puntos en Lenguaje.'

  } else {

    resultado.value =
      '❌ Incorrecto. Intenta nuevamente.'

  }

}
function responderCiencias(respuesta) {

  if (respuesta === 'B') {
    puntos.value +=10
    resultado.value =
      '🎉 ¡Correcto! Ganaste 10 puntos en Ciencias.'

  } else {

    resultado.value =
      '❌ Incorrecto. Intenta nuevamente.'

  }

}
function responderSociales(respuesta) {

  if (respuesta === 'C') {
    puntos.value +=10
    resultado.value =
      '🎉 ¡Correcto! Ganaste 10 puntos en Ciencias Sociales.'

  } else {

    resultado.value =
      '❌ Incorrecto. Intenta nuevamente.'

  }

}
function responderIngles(respuesta) {

  if (respuesta === 'B') {
    puntos.value +10
    resultado.value =
      '🎉 ¡Correcto! Ganaste 10 puntos en Inglés.'

  } else {

    resultado.value =
      '❌ Incorrecto. Intenta nuevamente.'

  }

}
function responderTecnologia(respuesta) {

  if (respuesta === 'B') {
    puntos.value +=10
    resultado.value =
      '🎉 ¡Correcto! Ganaste 10 puntos en Tecnología.'

  } else {

    resultado.value =
      '❌ Incorrecto. Intenta nuevamente.'

  }

}
</script>


<style>

/* =========================
   GENERAL
========================== */

* {

  margin: 0;

  padding: 0;

  box-sizing: border-box;

}


body {

  font-family:
    Arial,
    Helvetica,
    sans-serif;

  background: #f5f7fb;

}


button,
input {

  font-family: inherit;

}


button {

  cursor: pointer;

}


/* =========================
   APP
========================== */

.app {

  min-height: 100vh;

  width: 100%;

}


/* =========================
   LOGIN
========================== */

.login-page {

  min-height: 100vh;

  width: 100%;

  display: flex;

  justify-content: center;

  align-items: center;

  padding: 20px;

  background:
    linear-gradient(
      135deg,
      #eef4ff,
      #f8faff
    );

}


.login-card {

  width: 100%;

  max-width: 430px;

  background: white;

  padding: 40px;

  border-radius: 25px;

  box-shadow:
    0 15px 45px
    rgba(0, 0, 0, 0.10);

  text-align: center;

}


.logo {

  display: flex;

  justify-content: center;

  align-items: center;

  gap: 12px;

  margin-bottom: 10px;

}


.logo-circle {

  width: 52px;

  height: 52px;

  display: flex;

  justify-content: center;

  align-items: center;

  background: #4f46e5;

  color: white;

  border-radius: 50%;

  font-size: 27px;

  font-weight: bold;

}


.logo h1 {

  color: #30358f;

  font-size: 32px;

  letter-spacing: 2px;

}


.subtitle {

  color: #777;

  font-size: 14px;

  margin-bottom: 30px;

  line-height: 1.5;

}


.form-group {

  text-align: left;

  margin-bottom: 20px;

}


.form-group label {

  display: block;

  margin-bottom: 8px;

  font-weight: bold;

  color: #333;

}


.form-group input {

  width: 100%;

  padding: 14px 16px;

  border: 1px solid #ddd;

  border-radius: 12px;

  outline: none;

  font-size: 15px;

  transition: 0.2s;

}


.form-group input:focus {

  border-color: #4f46e5;

  box-shadow:
    0 0 0 3px
    rgba(79, 70, 229, 0.10);

}


.login-button {

  width: 100%;

  padding: 15px;

  border: none;

  border-radius: 12px;

  background: #4f46e5;

  color: white;

  font-size: 16px;

  font-weight: bold;

  transition: 0.2s;

}


.login-button:hover {

  background: #3730a3;

  transform: translateY(-1px);

}


.error {

  margin-top: 15px;

  color: #dc2626;

  font-size: 14px;

}


.login-info {

  margin-top: 25px;

  color: #999;

  font-size: 13px;

}


/* =========================
   NAVBAR
========================== */

.navbar {

  width: 100%;

  height: 75px;

  background: white;

  display: flex;

  justify-content: space-between;

  align-items: center;

  padding: 0 6%;

  box-shadow:
    0 2px 12px
    rgba(0, 0, 0, 0.06);

}


.brand {

  display: flex;

  align-items: center;

  gap: 10px;

  font-weight: bold;

  color: #30358f;

  font-size: 22px;

  letter-spacing: 1px;

}


.brand-icon {

  width: 40px;

  height: 40px;

  border-radius: 50%;

  background: #4f46e5;

  color: white;

  display: flex;

  justify-content: center;

  align-items: center;

  font-weight: bold;

}


.user-area {

  display: flex;

  align-items: center;

  gap: 20px;

  color: #555;

  font-size: 14px;

}


.logout-button {

  border: none;

  background: #f1f1f1;

  color: #444;

  padding: 9px 15px;

  border-radius: 9px;

}


.logout-button:hover {

  background: #e5e5e5;

}


/* =========================
   MAIN
========================== */

.main-content {

  width: 90%;

  max-width: 1250px;

  margin: auto;

  padding: 45px 0;

}


.welcome {

  text-align: center;

  margin-bottom: 35px;

}


.welcome h1 {

  color: #292f7d;

  font-size: 32px;

  margin-bottom: 10px;

}


.welcome p {

  color: #777;

}


/* =========================
   STUDENT CARD
========================== */

.student-card {

  background: white;

  border-radius: 20px;

  padding: 25px;

  display: flex;

  align-items: center;

  gap: 20px;

  margin-bottom: 45px;

  box-shadow:
    0 5px 20px
    rgba(0, 0, 0, 0.06);

}


.student-avatar {

  width: 65px;

  height: 65px;

  min-width: 65px;

  border-radius: 50%;

  background: #4f46e5;

  color: white;

  display: flex;

  align-items: center;

  justify-content: center;

  font-size: 28px;

  font-weight: bold;

}


.student-info {

  flex: 1;

}


.student-info h2 {

  color: #333;

  margin-bottom: 7px;

}


.student-info p {

  color: #777;

}


.student-info strong {

  color: #4f46e5;

}


.progress-info {

  width: 250px;

  display: flex;

  align-items: center;

  gap: 10px;

  font-size: 13px;

  color: #777;

}


.progress-bar {

  flex: 1;

  height: 8px;

  background: #eee;

  border-radius: 10px;

  overflow: hidden;

}


.progress-fill {

  height: 100%;

  background: #4f46e5;

  border-radius: 10px;

}


/* =========================
   SECTION TITLE
========================== */

.section-title {

  text-align: center;

  margin-bottom: 25px;

}


.section-title h2 {

  font-size: 27px;

  color: #333;

  margin-bottom: 8px;

}


.section-title p {

  color: #777;

}


/* =========================
   ISLANDS
========================== */

.islands {

  display: grid;

  grid-template-columns:
    repeat(3, 1fr);

  gap: 25px;

}


.island {

  background: white;

  border-radius: 22px;

  padding: 25px;

  display: flex;

  gap: 18px;

  min-height: 280px;

  box-shadow:
    0 8px 25px
    rgba(0, 0, 0, 0.07);

  transition: 0.25s;

  border-top: 6px solid #4f46e5;

}


.island:hover {

  transform: translateY(-5px);

  box-shadow:
    0 14px 30px
    rgba(0, 0, 0, 0.10);

}


.island-icon {

  font-size: 38px;

  width: 55px;

  min-width: 55px;

  height: 55px;

  display: flex;

  justify-content: center;

  align-items: center;

  background: #f1f2ff;

  border-radius: 15px;

}


.island-content {

  flex: 1;

}


.island h2 {

  color: #30358f;

  margin-bottom: 9px;

  font-size: 21px;

}


.island p {

  color: #777;

  line-height: 1.5;

  font-size: 14px;

  margin-bottom: 15px;

}


.level {

  display: flex;

  justify-content: space-between;

  align-items: center;

  margin-bottom: 8px;

  color: #777;

  font-size: 14px;

}


.level strong {

  background: #4f46e5;

  color: white;

  padding: 4px 10px;

  border-radius: 15px;

  font-size: 13px;

}


.island-progress {

  height: 7px;

  width: 100%;

  background: #eee;

  border-radius: 10px;

  overflow: hidden;

  margin-bottom: 6px;

}


.island-progress div {

  height: 100%;

  background: #4f46e5;

  border-radius: 10px;

}


.progress-text {

  font-size: 12px;

  color: #888;

}


.island-button {

  width: 100%;

  border: none;

  background: #4f46e5;

  color: white;

  padding: 11px;

  border-radius: 10px;

  margin-top: 15px;

  font-weight: bold;

}


.island-button:hover {

  background: #3730a3;

}


/* =========================
   COLORES DE ISLAS
========================== */

.math {

  border-top-color: #ef4444;

}


.math .island-icon {

  background: #fff0f0;

}


.language {

  border-top-color: #f59e0b;

}


.language .island-icon {

  background: #fff8e8;

}


.science {

  border-top-color: #10b981;

}


.science .island-icon {

  background: #edfff8;

}


.social {

  border-top-color: #3b82f6;

}


.social .island-icon {

  background: #eff6ff;

}


.english {

  border-top-color: #8b5cf6;

}


.english .island-icon {

  background: #f5f0ff;

}


.technology {

  border-top-color: #06b6d4;

}


.technology .island-icon {

  background: #ecfeff;

}


/* =========================
   RETOS
========================== */

.challenge-section {

  margin-top: 45px;

}


.challenge-card {

  background: white;

  border-radius: 20px;

  padding: 25px;

  display: flex;

  align-items: center;

  gap: 20px;

  box-shadow:
    0 5px 20px
    rgba(0, 0, 0, 0.06);

}


.challenge-icon {

  font-size: 42px;

}


.challenge-card h2 {

  color: #333;

  margin-bottom: 5px;

}


.challenge-card p {

  color: #777;

}


.challenge-button {

  margin-left: auto;

  border: none;

  background: #f59e0b;

  color: white;

  padding: 12px 20px;

  border-radius: 10px;

  font-weight: bold;

}


/* =========================
   FOOTER
========================== */

.footer {

  text-align: center;

  padding: 25px;

  color: #999;

  font-size: 13px;

}


/* =========================
   MODAL
========================== */

.modal-background {

  position: fixed;

  inset: 0;

  background:
    rgba(0, 0, 0, 0.45);

  display: flex;

  justify-content: center;

  align-items: center;

  padding: 20px;

  z-index: 100;

}


.modal {

  width: 100%;

  max-width: 430px;

  background: white;

  border-radius: 25px;

  padding: 35px;

  text-align: center;

  position: relative;

  box-shadow:
    0 20px 50px
    rgba(0, 0, 0, 0.2);

}


.close-modal {

  position: absolute;

  top: 12px;

  right: 15px;

  border: none;

  background: none;

  font-size: 30px;

  color: #888;

}


.modal-icon {

  font-size: 55px;

  margin-bottom: 10px;

}


.modal h2 {

  color: #30358f;

  margin-bottom: 8px;

}


.modal > p {

  color: #777;

}


.modal-text {

  margin: 15px 0;

  line-height: 1.5;

}


.modal-level {

  background: #f3f4ff;

  padding: 12px;

  border-radius: 10px;

  color: #555;

  margin: 20px 0;

}


.modal-level strong {

  color: #4f46e5;

}


.start-button {

  width: 100%;

  padding: 13px;

  border: none;

  border-radius: 10px;

  background: #4f46e5;

  color: white;

  font-weight: bold;

}


/* =========================
   TOAST
========================== */

.toast {

  position: fixed;

  bottom: 25px;

  right: 25px;

  background: #333;

  color: white;

  padding: 15px 20px;

  border-radius: 12px;

  box-shadow:
    0 5px 20px
    rgba(0, 0, 0, 0.2);

  z-index: 200;

}


/* =========================
   RESPONSIVE
========================== */

@media (max-width: 1000px) {

  .islands {

    grid-template-columns:
      repeat(2, 1fr);

  }

}


@media (max-width: 700px) {

  .navbar {

    padding: 0 20px;

  }


  .user-area span {

    display: none;

  }


  .main-content {

    width: 94%;

    padding: 30px 0;

  }


  .welcome h1 {

    font-size: 25px;

  }


  .student-card {

    flex-wrap: wrap;

  }


  .progress-info {

    width: 100%;

  }


  .islands {

    grid-template-columns: 1fr;

  }


  .challenge-card {

    flex-direction: column;

    text-align: center;

  }


  .challenge-button {

    margin-left: 0;

    width: 100%;

  }

}


@media (max-width: 450px) {

  .login-card {

    padding: 30px 20px;

  }


  .island {

    flex-direction: column;

  }


  .island-icon {

    width: 55px;

  }

}
/* =========================
   ACTIVIDAD
========================== */

.activity-page {

  min-height: 100vh;

  background: #f5f7fb;

  display: flex;

  justify-content: center;

  align-items: center;

  padding: 30px;

}


.activity-card {

  width: 100%;

  max-width: 700px;

  background: white;

  padding: 45px;

  border-radius: 25px;

  text-align: center;

  box-shadow:
    0 10px 35px
    rgba(0, 0, 0, 0.08);

}


.activity-icon {

  font-size: 60px;

  margin-bottom: 15px;

}

  .activity-card h1 {
  color: #2e7d32;
  margin-bottom: 8px;
  font-size: 30px;
  line-height: 1.3;
  white-space: nowrap;
}



.activity-subtitle {

  color: #777;

  margin-bottom: 30px;

}


.question-box {

  background: #f3f4ff;

  padding: 30px;

  border-radius: 20px;

}


.question-box h2 {

  color: #333;

  margin-bottom: 25px;

}


.answers {

  display: grid;

  grid-template-columns: 1fr 1fr;

  gap: 15px;

}


.answers button {

  padding: 15px;

  border: none;

  border-radius: 12px;

  background: #4f46e5;

  color: white;

  font-size: 18px;

  font-weight: bold;

}


.answers button:hover {

  background: #3730a3;

}


.result {

  margin-top: 25px;

  font-size: 18px;

  font-weight: bold;

}


.back-button {

  margin-top: 30px;

  padding: 12px 20px;

  border: none;

  border-radius: 10px;

  background: #eee;

  color: #444;

  font-weight: bold;

}

</style>