import { Component, OnInit } from '@angular/core';
import { HistoryService } from '../../services/history.service';
import { DatePipe, NgFor } from '@angular/common';

@Component({
  selector: 'app-history-table',
  standalone: true,
  imports: [NgFor, DatePipe],
  templateUrl: './history-table.component.html',
  styleUrl: './history-table.component.css'
})
export class HistoryTableComponent implements OnInit {
  history: any[] = [];
  constructor(private historyService:HistoryService) {

  }

  ngOnInit(): void {
    this.historyService.getHistory().subscribe((res)=> {
      this.history = res;
    })
  }
}
