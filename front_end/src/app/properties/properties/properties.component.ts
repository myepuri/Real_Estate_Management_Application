import { Component, OnInit } from '@angular/core';
import * as moment from 'moment';
import { PropertyService } from 'src/app/properties.service';

@Component({
  selector: 'app-properties',
  templateUrl: './properties.component.html',
  styleUrls: ['./properties.component.css']
})
export class PropertiesComponent implements OnInit {

  propertytype: any;
  location: any;
  startdate: any;
  enddate: any;
  properties: any



  constructor(private propertyService: PropertyService) { }

  ngOnInit() {
    
  }

  filterProperties() {
    const startdate_format = moment(this.startdate).format('YYYY-MM-DD');
    const enddate_format = moment(this.enddate).format('YYYY-MM-DD');
    if(this.propertytype === 'house') {
      this.propertyService.getHouses(this.location, startdate_format , enddate_format).subscribe(data => {
        console.log("Houses");
        console.log(data);
        this.properties = data;
      })
    }

    if(this.propertytype === 'apartment') {
      this.propertyService.getApartments(this.location, startdate_format , enddate_format).subscribe(data => {
        console.log("Apartments");
        console.log(data);
        this.properties = data;
      })
    }

    if(this.propertytype === 'commercialbuilding') {
      this.propertyService.getBuildings(this.location, startdate_format, enddate_format).subscribe(data => {
        console.log("Commercial Buildings");
        console.log(data);
        this.properties = data;
      })
    }


  }

}
