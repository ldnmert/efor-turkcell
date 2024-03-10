import { Component } from '@angular/core';
import { AdminPanelService } from '../../services/admin-panel.service';
import { Performance } from '../../model/performance';

import * as XLSX from 'xlsx';
import { saveAs } from 'file-saver';





@Component({
  selector: 'app-adminpanel',
  templateUrl: './adminpanel.component.html',
  styleUrl: './adminpanel.component.css'
})
export class AdminpanelComponent {
  filter = {
    memberId: '',
    startDate: '',
    endDate: '',
    begin : '',
    end: '',
    excuse: '',
    excuseHours: '',
    timeout: ''
  };
  filteredPerformances: Performance[] = [];

  constructor(private adminPanel: AdminPanelService) { }

  ngOnInit(): void {
  }

  filterPerformances() {
    this.adminPanel.filterPerformances(this.filter.memberId, this.filter.startDate, this.filter.endDate,
        this.filter.excuse, this.filter.excuseHours, this.filter.timeout)
      .subscribe(data => {
        this.filteredPerformances = data;
      }); 
  }

  exportToExcel(): void {

    const ws: XLSX.WorkSheet = XLSX.utils.table_to_sheet(document.getElementById('performance-table'));
    const wb: XLSX.WorkBook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(wb, ws, 'Sheet1');
    const excelBuffer: any = XLSX.write(wb, { bookType: 'xlsx', type: 'array' });
    this.saveAsExcelFile(excelBuffer, 'performance_table');
  }

  private saveAsExcelFile(buffer: any, fileName: string): void {
    const data: Blob = new Blob([buffer], { type: 'application/octet-stream' });
    saveAs(data, fileName + '_export_' + new Date().getTime() + '.xlsx');
  }
}

