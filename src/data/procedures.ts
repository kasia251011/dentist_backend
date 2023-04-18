import Procedure from "../model/Procedure"

export const initProcedures = () => {
  Procedure.insertMany([
    {
      name: 'Teeth cleaning',
      price: 100,
      duration: 0.5
    },
    {
      name: 'Tooth extraction',
      price: 250,
      duration: 1.0
    },
    {
      name: 'Root canal',
      price: 500,
      duration: 1.5
    },
    {
      name: 'Filling',
      price: 150,
      duration: 1.0
    },
    {
      name: 'Teeth whitening',
      price: 200,
      duration: 1.0
    },
    {
      name: 'Dental crown',
      price: 2.0,
      duration: 2.0
    },
    {
      name: 'Dental implant',
      price: 2.5,
      duration: 3.0
    },
    {
      name: 'Braces',
      price: 2.5,
      duration: 5.0
    },
    {
      name: 'Gum surgery',
      price: 1.0,
      duration: 2.0
    },
    {
      name: 'Oral cancer screening',
      price: 0.5,
      duration: 0.5
    }
  ]
)};