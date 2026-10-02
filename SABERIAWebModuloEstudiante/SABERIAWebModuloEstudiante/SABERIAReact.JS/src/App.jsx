import { useState } from "react";
import { FaSquareRootAlt, FaBookOpen, FaLanguage, FaCheckCircle, FaTrophy,FaMedal, FaStar,FaExclamationCircle, FaLaptop, FaGlobeAmericas } from 'react-icons/fa';
import './App.css'
import { FaFlask } from "react-icons/fa6";

function App() {
  const [pantalla, setPantalla] = useState('registro')

  // crear cuenta
  const [Cuenta, setCuenta] = useState(null)

  // Datos del usuario que inicio sesión
  const [usuarioActual, setUsuarioActual] = useState(null)

  // Datos del formulario de registro
  const [registro, setDatosRegistro] = useState({
    nombre: '',
    correo: '',
    password: '',
    confirmar: '',
    nivel: 'secundaria',
  })

  // Datos del formulario de inicio de sesión
  const [login, setLogin] = useState({
    correo: '',
    password: '',
  })
  // crear cuenta
  function crearCuenta(event) {
  event.preventDefault()

  if (registro.password !== registro.confirmar) {
    alert('Las contraseñas no coinciden')
    return
  }
  setCuenta ({
    nombre: registro.nombre,
    correo: registro.correo,
    password: registro.password,
    nivel: registro.nivel

  })
  alert('Cuenta creada con éxito. Ahora puedes iniciar sesión.')

  setLogin({
    correo: registro.correo,
    password: ''
     })
  setPantalla('Login')
  }

  // iniciar sesión
  function iniciarSesion(event) {
    event.preventDefault()
    
    if (!Cuenta) {
      alert('No hay ninguna cuenta registrada. Por favor, crea una cuenta primero.')
      return
    }

    if (login.correo === Cuenta.correo && login.password === Cuenta.password) {
      setUsuarioActual(Cuenta)
      setPantalla('perfil')
    } else {
      alert('Correo o contraseña incorrectos.')
    }
  }
  //pantalla crear perfil
  if(pantalla==='registro'){
    return (
      <div className="contenedor">
        <div className="tarjeta">
          <h1>SABERIA</h1>
          <h2>Crear cuenta</h2>

          <p className="subtitulo">Registrate para ingresar al ecosistema educativo
          </p>

          <form onSubmit={crearCuenta}>
            <label>Nombre completo</label>
            <input
              type="text"
              placeholder="Escribe tu nombre"
              value={registro.nombre}
              onChange={(e) => setDatosRegistro({ ...registro, nombre: e.target.value })}
              required
            />
            <label>Correo electrónico</label>
            <input
              type="email"
              placeholder="correo@ejemplo.com"
              value={registro.correo}
              onChange={(e) => setDatosRegistro({ ...registro, correo: e.target.value })}
              required
            />
            <label>Contraseña</label>
            <input
              type="password"
              placeholder="crea una contraseña"
              value={registro.password}
              onChange={(e) => setDatosRegistro({ ...registro, password: e.target.value })}
              required
            />
            <label>Confirmar contraseña</label>
            <input
              type="password"
              placeholder="Confirma tu contraseña"
              value={registro.confirmar}
              onChange={(e) => setDatosRegistro({ ...registro, confirmar: e.target.value })}
              required
            />
            <label>Nivel educativo</label>
            <select
              value={registro.nivel}
              onChange={(e) => setDatosRegistro({ ...registro, nivel: e.target.value })}
            >
              <option value="primaria">primaria</option>
              <option value="secundaria">secundaria</option>
              <option value="Bachiller">Bachiller</option>
            </select>
            <button type="submit">Crear cuenta</button>
          </form>

          <p className="enlace ">¿Ya tienes una cuenta?
              </p>
              <button
              className="boton-secundario"
             onClick={() => setPantalla('Login')}>

              Iniciar sesión
              </button>
        </div>
      </div>
    )
  }

// pantalla iniciar sesión
if(pantalla==='Login'){
  return (
    <div className="contenedor">
      <div className="tarjeta">

        <h1>SABERIA</h1>
        <h2>Iniciar sesión</h2>

        <form onSubmit={iniciarSesion}>

          <label>Correo electrónico</label>
          <input
            type="email"
            value={login.correo}
            onChange={(e) =>
              setLogin({
                ...login,
                correo: e.target.value
              })
            }
            required
          />

          <label>Contraseña</label>
          <input
            type="password"
            value={login.password}
            onChange={(e) =>
              setLogin({
                ...login,
                password: e.target.value
              })
            }
            required
          />

          <button type="submit">
            Iniciar sesión
          </button>

        </form>

        <p className="enlace">
          ¿No tienes cuenta?
        </p>

        <button
          className="boton-secundario"
          onClick={() => setPantalla('registro')}
        >
          Crear cuenta
        </button>

      </div>
    </div>
  )
}
  
//pantalla perfil del estudiante 
if(pantalla==='perfil'){
  return (
    <div className="perfil">
      <header className="encabezado">
        <h1>SABERÍA-Plataforma Educativa </h1>

        <button className="cerrar-sesion"
          onClick={() => {
            setUsuarioActual(null);
            setPantalla('Login');
          } }>
          Cerrar sesión
        </button>
      </header>
      
      <main>
  <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', width: '100%', margin: '0px auto' }}>
  <h2 className="titulo-perfil" style={{ margin: 0 }}>Perfil del estudiante</h2>
  <button className="btn-editar">
     Editar información
  </button>
</div>

        <div className= "perfil-contenido">
          {/*Tarjeta 1:Informacion Estudiante Arriba a la izquierda*/}
        <section className="tarjeta perfil">
          <h3>Información personal</h3>
          <p><strong> Nombre:</strong> {usuarioActual?.nombre} </p>
          <p><strong> correo:</strong> {usuarioActual?.correo} </p>
          <p><strong> Edad:</strong>  {usuarioActual?.edad} </p>
          <p><strong> Nivel educativo:</strong> {usuarioActual?.nivel} </p>
          <p><strong> Nivel SABERIA:</strong> Explorador-Nivel 2 </p>
        </section>

        {/*Tarjeta 2:Resumen Academico Arriba a la derecha*/}
        <section className="tarjeta-perfil">
          <h3>Resumen academico</h3>
          <div className="resumen">
            <div className="item-resumen">
              <FaCheckCircle className="icono-resumen" style={{ color: 'green'}} />
             <strong>55</strong>
             <span>Actividades completadas</span>
            </div>

            <div className="item-resumen">
              <FaStar className="icono-resumen" style={{color: '#d977o6'}} />
              <strong>450</strong>
              <span>Puntos acumulados</span>
            </div>


            <div className="item-resumen">
              <FaMedal className="icono-resumen" style={{color: '#eab308'}}/>
            <strong>8</strong><span>Medallas obtenidas</span>
            </div>
          </div>
        </section>

        {/*Tarjeta 3:progreso por asignatura Abajo izquierda*/}
        <section className="tarjeta-perfil tarjeta-completada">
          <h3>Progreso por asignatura</h3>

          <div className="Lista-asignaturas">
            <div className ="item-asignatura">
              <span><FaSquareRootAlt/> Matematicas:</span>
              <div><strong>45%</strong><span style={{color: 'green'}}> <FaCheckCircle /> Buen progreso</span></div>
            </div> 


            <div className ="item-asignatura">
          <span><FaBookOpen/> Lenguaje:</span>
          <div><strong>50%</strong><span style={{color: '#d97706'}}> <FaTrophy /> Excelente</span></div>
          </div>

          <div className ="item-asignatura">
          <span><FaFlask/> ciencias:</span>
          <div><strong>25%</strong><span style={{color: 'orange'}}> <FaExclamationCircle /> Necesita mejorar</span></div>
          </div>

          <div className ="item-asignatura">
          <span><FaGlobeAmericas/> ciencias sociales:</span>
          <div><strong>40%</strong><span style={{color: 'green'}}> <FaCheckCircle /> Buen progreso</span></div>
          </div>

          <div className="item-asignatura">
          <span><FaLanguage /> Inglés:</span>
          <div><strong>20%</strong><span style={{color: 'orange'}}> <FaExclamationCircle /> Necesita mejorar</span></div>
          </div>

          <div className="item-asignatura">
          <span><FaLaptop /> Tecnologia:</span>
          <div><strong>35%</strong><span style={{color: 'green'}}> <FaCheckCircle /> Buen progreso</span></div>
          </div>
        </div>
        </section>
        {/*Tarjeta 4: Información del Acudiente Abajo derecha */}
        <section className="tarjeta-perfil">
          <h3>Información del Acudiente</h3>
          <p><strong> Nombre:</strong> {usuarioActual?.nombreAcudiente} </p>
          <p><strong> Parentesco:</strong> {usuarioActual?.parentescoAcudiente} </p>
          <p><strong> correo:</strong> {usuarioActual?.correoAcudiente} </p>
          <p><strong> Telefono:</strong> {usuarioActual?.telefonoAcudiente} </p>
        </section>
        </div>
      </main>
    </div>
  )
}
    
  return null
}

export default App;
