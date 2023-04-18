import mongoose from 'mongoose';

export interface Procedure {
  name: string;
  price: number;
  duration: number;
}

export interface ProcedureModel extends Procedure, Document {};

const procedureSchema = new mongoose.Schema({
  name: { type: String, required: true, unique: true },
  price: { type: Number, required: true },
  duration: { type: Number, required: true },
})

export default mongoose.model<ProcedureModel>('Procedure', procedureSchema);