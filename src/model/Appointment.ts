import mongoose, { Schema } from 'mongoose';

export interface Appointment {
  date: Date;
  patient: string;
  procedure: string;
}

export interface AppointmentModel extends Appointment, Document {};

const appointmentSchema = new mongoose.Schema({
  date: { type: Date, required: true },
  patient: { type: Schema.Types.ObjectId, required: true },
  procedure: { type: Schema.Types.ObjectId, required: true }
})

export default mongoose.model<AppointmentModel>('Appointment', appointmentSchema);