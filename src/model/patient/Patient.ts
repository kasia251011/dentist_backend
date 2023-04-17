import mongoose from 'mongoose';
import { Tooth, toothSchema } from './Tooth';

export interface Patient {
  avatar: string;
  name: string;
  surname: string;
  pesel: string;
  dateOfBirth: Date;
  email: string;
  phoneNumber: string;
  teeth: Tooth[];
}

export interface PatientModel extends Patient, Document {};

const patientSchema = new mongoose.Schema({
  name: { type: String, required: true },
  surname: { type: String, required: true },
  avatar: { type: String, required: false },
  pesel: {  type: String, required: true, unique: true },
  dateOfBirth: { type: Date, required: true },
  email: { type: String, required: true },
  phoneNumber: { type: String, required: true },
  teeth: {type: [toothSchema], required: false}
})

export default mongoose.model<PatientModel>('Patient', patientSchema);