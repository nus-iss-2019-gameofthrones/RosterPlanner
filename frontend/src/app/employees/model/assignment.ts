export interface Assignment{
    employee:{
        name:String,
        employeeID:number,
        shift:number,
        employeeGrade:number,
        preferredLocation:number[],
        shiftAvailability:number[],

    },
    job:{
        jobID:number,
        jobLocation:number,
        shift:number
    }
}