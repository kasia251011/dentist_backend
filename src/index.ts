// require('dotenv').config();
import dotenv from 'dotenv';
import express from 'express';
import mongoose from 'mongoose';
import patientRoutes from './routes/Patient';
import appointmentRoutes from './routes/Appointment';
import procedureRoutes from './routes/Procedure';
import cors from 'cors';
import { initPatients } from './data/patients';
import { initProcedures } from './data/procedures';

dotenv.config()

const mongoString = process.env.DATABASE_URL;



mongoose.connect(mongoString ?? '');
const database = mongoose.connection;

database.on('error', (error: any) => {
    console.log(error)
})

database.once('connected', async () => {
    try {
        await mongoose.connection.db.dropDatabase();
        console.log('Dropped all collections');
      } catch (error) {
        console.log(error);
      }
    console.log('Database Connected');

    initPatients();
    console.log('Patients initialized');
    initProcedures();
    console.log('Procedures initialized');
})

const app = express();

app.use(cors())
app.use(express.json());
app.use('/patients', patientRoutes);
app.use('/appointments', appointmentRoutes);
app.use('/procedures', procedureRoutes);

app.listen(8080, () => {
    console.log(`Server Started at ${8080}`)
})