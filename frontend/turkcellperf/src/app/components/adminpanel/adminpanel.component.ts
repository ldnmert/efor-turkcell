import { Component } from '@angular/core';
import { AdminPanelService } from '../../services/admin-panel.service';
import { Performance } from '../../model/performance';


@Component({
  selector: 'app-adminpanel',
  templateUrl: './adminpanel.component.html',
  styleUrl: './adminpanel.component.css'
})
export class AdminpanelComponent {
  filter = {
    memberId: '',
    startDate: '',
    endDate: ''
  };
  filteredPerformances: Performance[] = [];

  constructor(private adminPanel: AdminPanelService) { }

  ngOnInit(): void {
  }

  filterPerformances() {
    this.adminPanel.filterPerformances(this.filter.memberId, this.filter.startDate, this.filter.endDate)
      .subscribe(data => {
        this.filteredPerformances = data;
      }); 
  }
}
