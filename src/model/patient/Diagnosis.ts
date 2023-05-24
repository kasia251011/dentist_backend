import mongoose from 'mongoose';

export interface Diagnosis {
  date: Date;
  src: String;
  description: string;
}

export interface DiagnosisModel extends Diagnosis, Document {};

export const diagnosisSchema = new mongoose.Schema({
  date: { type: Date, required: true },
  src: { type: String, required: false },
  description: { type: String, required: false }
  
})

export default mongoose.model<Diagnosis>('diagnosis', diagnosisSchema);