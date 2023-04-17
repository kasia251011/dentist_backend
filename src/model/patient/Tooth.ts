import mongoose from 'mongoose';
import { ToothHistory, toothHistorySchema } from './ToothHistory';

export interface Tooth {
  no: number;
  state: 'HEALTHY' | 'ILL';
  hitory: ToothHistory[];
}

export interface ToothModel extends Tooth, Document {};

export const toothSchema = new mongoose.Schema({
  no: { type: Number, required: true },
  state: { type: String, required: true },
  hitory: { type: [toothHistorySchema], required: false }
})