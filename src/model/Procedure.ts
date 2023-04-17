import mongoose from 'mongoose';

export interface Procedure {
  name: string;
  price: number;
  duration: number;
}

export interface ProcedureModel extends Procedure, Document {};

const procedureSchema = new mongoose.Schema({
  name: { type: String, required: true, unique: true },
  surname: { type: Number, required: true },
  avatar: { type: Number, required: false },
})

export default mongoose.model<ProcedureModel>('Procedure', procedureSchema);