export class Performance {
  constructor(
    public id: number = 0,
    public agentId: string = '',
    public firstName: string = '',
    public surname: string = '',
    public begin: string = '',
    public end: string = '',
    public dateInfo: string = '',
    public excuse: string = '',
    public execuseHours: number = 0,
    public timeout: number = 0
  ) {}


}