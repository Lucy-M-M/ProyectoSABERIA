const express= require('express');
const cors= require('cors'); // <--- 1.importar cors
const app= express();

app.use(cors()); //<----2.activar cors para permitir solicitudes desde cualquier origen
const PORT=3000;

app.get('/',(req, res)=>{
    res.json({
        mensaje: 'API de SABERIA funcionando correctamente'
    });
});

 app.get('/api/estudiantes',(req, res)=> {
        res.json([
            {
                id:1,
                nombre:'carlos mendez',
                correo: 'carlos@ejemplo.com',
                edad:12,
                nivelEducativo:'secundaria',
                nivelSaberia:'Explorador-Nivel 4'
            },
            { 
                id:2,
                nombre: 'ana torres',
                correo: 'ana@ejemplo.com',
                edad:14,
                nivelEducativo:'secundaria',
                nivelSaberia: 'Explorador-Nivel 2'
            },
            {
                id:3,
                nombre: 'juan perez',
                correo: 'juan@ejemplo.com',
                edad:16,
                nivelEducativo:'bachiller',
                nivelSaberia: 'Explorador-Nivel 5'
            },
            {
                id:4,
                nombre: 'maria lopez',
                correo: 'maria@ejemplo.com',
                edad:13,
                nivelEducativo:'secundaria',
                nivelSaberia: 'Explorador-Nivel 6'
            },
            {
                id:5,
                nombre: 'pedro ramirez',
                correo: 'pedro@ejemplo.com',
                edad:15,
                nivelEducativo:'secundaria',
                nivelSaberia: 'Explorador-Nivel 4'
            },
            {
                id:6,
                nombre: 'laura gomez',
                correo: 'laura@ejemplo.com',
                edad:14,
                nivelEducativo:'secundaria',
                nivelSaberia: 'Explorador-Nivel 1'
            },
            
        {
                id:7,
                nombre: 'diego martinez',
                correo: 'diego@ejemplo.com',
                edad:16,
                nivelEducativo:'bachiller',
                nivelSaberia: 'Explorador-Nivel 5'}
            ]);
        });

        app.get('/api/estudiantes/:id',(req, res)=>{
            const id=
            Number(req.params.id);

            const estudiantes= [
                {
                id:1,
                nombre:'Carlos Mendez',
                correo: 'carlos@ejemplo.com',
                edad:12,
                nivelEducativo:'Secundaria',
                nivelSaberia:'Explorador-Nivel 4',
                acudiente:{
                    nombre:'Maria Mendez',
                    parentesco:'Madre',
                    correo:'maria@ejemplo.com',
                    telefono:'555-1234'
                },
                resumenAcademico:{
                    actividadesCompletadas: 55,
                    puntosAcumulados:450,
                     medallasObtenidas: 8
                
                },

                progresoAsignaturas: {
                    matematicas: 45,
                    lenguaje: 50,
                    ciencias: 25,
                    cienciasSociales: 40,
                    ingles: 20,
                    tecnologia: 35
                }
            
            },
            {
                id:2,
                nombre: 'Ana Torres',
                correo: 'ana@ejemplo.com',
                edad:14,
                nivelEducativo:'Secundaria',
                nivelSaberia: 'Explorador-Nivel 2',
                acudiente:{
                    nombre:'Juan Torres',
                    parentesco:'Padre',
                    correo:'juan@ejemplo.com',
                    telefono:'555-5678'
                },
                resumenAcademico:{
                    actividadesCompletadas: 20,
                    puntosAcumulados: 200,
                    medallasObtenidas: 5
                },
                progresoAsignaturas: {
                    matematicas: 30,
                    lenguaje: 40,
                    ciencias: 20,
                    cienciasSociales: 35,
                    ingles: 15,
                    tecnologia: 25
                }
            },
            {
                id:3,
                nombre: 'Juan Perez',
                correo: 'juan@ejemplo.com',
                edad:16,
                nivelEducativo:'Bachiller',
                nivelSaberia: 'Explorador-Nivel 5',
                acudiente:{
                    nombre:'Luis Perez',
                    parentesco:'Padre',
                    correo:'luis@ejemplo.com',
                    telefono:'555-9012'
                },
                resumenAcademico:{
                    actividadesCompletadas: 70,
                    puntosAcumulados: 500,
                    medallasObtenidas: 10
                },
                progresoAsignaturas: {
                    matematicas: 60,
                    lenguaje: 70,
                    ciencias: 50,
                    cienciasSociales: 65,
                    ingles: 45,
                    tecnologia: 55
                }
            },
            {
                id:4,
                nombre: 'Maria Lopez',
                correo: 'maria@ejemplo.com',
                edad:13,
                nivelEducativo:'Secundaria',
                nivelSaberia: 'Explorador-Nivel 6',
                acudiente:{
                    nombre:'Sebatian Lopez',
                    parentesco:'Padre',
                    correo:'carlos@ejemplo.com',
                    telefono:'555-3456'
                },
                resumenAcademico:{
                    actividadesCompletadas: 17,
                    puntosAcumulados: 500,
                    medallasObtenidas: 2
                },
                progresoAsignaturas: {
                    matematicas: 15,
                    lenguaje: 20,
                    ciencias: 10,
                    cienciasSociales: 25,
                    ingles: 10,
                    tecnologia: 15
                }
            },
            {
                id:5,
                nombre: 'Pedro Ramirez',
                correo: 'pedro@ejemplo.com',
                edad:15,
                nivelEducativo:'Secundaria',
                nivelSaberia: 'Explorador-Nivel 4',
                acudiente:{
                    nombre:'Ana Ramirez',
                    parentesco:'Madre',
                    correo:'ana@ejemplo.com',
                    telefono:'555-7890'
                },
                resumenAcademico:{
                    actividadesCompletadas: 25,
                    puntosAcumulados: 200,
                    medallasObtenidas: 4
                },
                progresoAsignaturas: {
                    matematicas:55,
                    lenguaje: 36,
                    ciencias: 20,
                    cienciasSociales: 35,
                    ingles: 15,
                    tecnologia: 25
                }
            },
            {
                id:6,
                nombre: 'Laura Gomez',
                correo: 'laura@ejemplo.com',
                edad:14,
                nivelEducativo:'Secundaria',
                nivelSaberia: 'Explorador-Nivel 1',
                acudiente:{
                    nombre:'Miguel Gomez',
                    parentesco:'Padre',
                    correo:'miguel@ejemplo.com',
                    telefono:'555-1111'
                },
                resumenAcademico:{
                    actividadesCompletadas: 19,
                    puntosAcumulados: 130,
                    medallasObtenidas: 1
                },
                progresoAsignaturas: {
                    matematicas: 15,
                    lenguaje: 30,
                    ciencias: 29,
                    cienciasSociales: 25,
                    ingles: 40,
                    tecnologia: 15
                }
            },
            {
                id:7,
                nombre: 'Diego Martinez',
                correo: 'diego@ejemplo.com',
                edad:16,
                nivelEducativo:'Bachiller',
                nivelSaberia: 'Explorador-Nivel 5',
                acudiente:{
                    nombre:'Sofia Martinez',
                    parentesco:'Madre',
                    correo:'sofia@ejemplo.com',
                    telefono:'555-2222'
                },
                resumenAcademico:{
                    actividadesCompletadas: 29,
                    puntosAcumulados: 150,
                    medallasObtenidas: 3
                },
                progresoAsignaturas: {
                    matematicas: 25,
                    lenguaje: 30,
                    ciencias: 38,
                    cienciasSociales: 47,
                    ingles: 15,
                    tecnologia: 40
                }

            }
        ];
       
       const estudiante = 
       estudiantes.find(est => est.id === id);

       if(!estudiante){
        return res.status(404).json({mensaje: 'Estudiante no encontrado'});
       }
       res.json(estudiante);
    });


app.listen(PORT,()=>{
    console.log(`Servidor de SABERIA funcionando en http://localhost:${PORT}`);
});
