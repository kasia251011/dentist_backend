import mongoose from 'mongoose';

export interface ToothHistory {
  date: Date;
  img?: string;
  description: string;
}

export interface ToothHistoryModel extends ToothHistory, Document {};

export const toothHistorySchema = new mongoose.Schema({
  date: { type: Date, required: true },
  img: { type: String, required: false },
  description: { type: String, required: false }
})

export default mongoose.model<ToothHistory>('tooth_history', toothHistorySchema);