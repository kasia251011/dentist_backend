import mongoose, { Schema } from 'mongoose';

export interface Appointment {
  date: string;
  time: string;
  patientId: string;
  procedureId: string;
}

export interface AppointmentModel extends Appointment, Document {};

const appointmentSchema = new mongoose.Schema({
  date: { type: String, required: true },
  time: { type: String, required: true },
  patientId: { type: Schema.Types.ObjectId, required: true, ref: 'Patient' },
  procedures: { type: Schema.Types.ObjectId, required: true, ref: 'Procedure' }
})

export default mongoose.model<AppointmentModel>('Appointment', appointmentSchema);