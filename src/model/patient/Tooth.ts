import mongoose from 'mongoose';
import { Diagnosis, diagnosisSchema } from './Diagnosis';

export interface Tooth {
  no: number;
  state: 'HEALTHY' | 'ILL';
  diagnoses: Diagnosis[];
}

export interface ToothModel extends Tooth, Document {};

export const toothSchema = new mongoose.Schema({
  no: { type: Number, required: true },
  state: { type: String, required: true },
  diagnoses: { type: [diagnosisSchema], required: false }
})