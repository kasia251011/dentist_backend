// require('dotenv').config();
import dotenv from 'dotenv';
import express from 'express';
import mongoose from 'mongoose';
import patientRoutes from './routes/Patient';
import appointmentRoutes from './routes/Appointment';
import procedureRoutes from './routes/Procedure';

dotenv.config()

const mongoString = process.env.DATABASE_URL;

mongoose.connect(mongoString ?? '');
const database = mongoose.connection;

database.on('error', (error: any) => {
    console.log(error)
})

database.once('connected', () => {
    console.log('Database Connected');
})

const app = express();

app.use(express.json());
app.use('/patients', patientRoutes);
app.use('/appointments', appointmentRoutes);
app.use('/procedures', procedureRoutes);

app.listen(8080, () => {
    console.log(`Server Started at ${8080}`)
})