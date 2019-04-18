export interface Employee{
    id:number;
    firstName:String;
    lastName:String;
    grade:number;
    shifts?:number[];
    preferredShifts:number[];
    station?:String[];
    preferredLocation?:number;
}