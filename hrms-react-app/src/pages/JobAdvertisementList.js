import React, { useState, useEffect } from 'react'
import { Icon, Menu, Table, Button} from 'semantic-ui-react'
import JobService from '../services/jobService'

export default function JobAdvertisementList() {

    const [jobs, setJobs] = useState([])

    useEffect(() => {
        let jobService = new JobService()
        jobService.getJobs().then(result => setJobs(result.data.data))
    }, [jobs])

    return (
        <div>
            <Table celled>
                <Table.Header>
                    <Table.Row>
                        <Table.HeaderCell>Status</Table.HeaderCell>
                        <Table.HeaderCell>Job Title</Table.HeaderCell>
                        <Table.HeaderCell>Description</Table.HeaderCell>
                        <Table.HeaderCell>City</Table.HeaderCell>
                        <Table.HeaderCell>Min. Salary</Table.HeaderCell>
                        <Table.HeaderCell>Max. Salary</Table.HeaderCell>
                        <Table.HeaderCell>Due Date</Table.HeaderCell>                        
                        <Table.HeaderCell>Company Name</Table.HeaderCell>                        
                    </Table.Row>
                </Table.Header>
                <Table.Body>
                    {
                        jobs.map((job, key) => (
                            <Table.Row key={key}>
                                <Table.Cell style={{textAlign: "center"}}>{job._active ? (
                                    <Icon color="green" name="checkmark"/>
                                ) : (
                                    <Icon color="red" name="close" />
                                )}
                                </Table.Cell>
                                <Table.Cell>{job.job.name}</Table.Cell>
                                <Table.Cell>{job.description}</Table.Cell>
                                <Table.Cell>{job.city.city_name}</Table.Cell>
                                <Table.Cell>{job.min_salary} TL</Table.Cell>
                                <Table.Cell>{job.max_salary} TL</Table.Cell>
                                <Table.Cell>{Intl.DateTimeFormat('tr-TR').format(new Date(job.due_date))}</Table.Cell>                                
                                <Table.Cell>{job.employer.company_name}</Table.Cell>                                
                            </Table.Row>
                        ))
                    }
                </Table.Body>

                <Table.Footer>
                    <Table.Row>
                        <Table.HeaderCell colSpan='8'>                        
                        <Button color='grey'>Add a new Job</Button>                             
                            <Menu floated='right' pagination>                                
                                <Menu.Item as='a' icon>
                                    <Icon name='chevron left' />
                                </Menu.Item>
                                <Menu.Item as='a'>1</Menu.Item>
                                <Menu.Item as='a' className='disabled'>2</Menu.Item>
                                <Menu.Item as='a'className='disabled'>3</Menu.Item>
                                <Menu.Item as='a'className='disabled'>4</Menu.Item>
                                <Menu.Item as='a' icon>
                                    <Icon name='chevron right' />
                                </Menu.Item>
                            </Menu>
                        </Table.HeaderCell>
                    </Table.Row>
                </Table.Footer>
            </Table>
        </div>
    )
}
