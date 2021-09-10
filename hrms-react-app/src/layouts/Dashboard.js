import React from 'react'
import Categories from './Categories'
import { Grid } from 'semantic-ui-react'
import JobAdvertisementList from '../pages/JobAdvertisementList'


export default function Dashboard() {
    return (
        <div >
            <Grid>
                <Grid.Row>
                    <Grid.Column width={3}>
                        <Categories />
                    </Grid.Column>
                    <Grid.Column width={13}>
                        <JobAdvertisementList />
                    </Grid.Column>
                </Grid.Row>
            </Grid>
        </div>
    )
}

