import React from 'react'
import { Menu } from 'semantic-ui-react'

export default function Categories() {
    return (
        <div>
            <Menu pointing vertical>
                <Menu.Item
                    name='Job Advertisements'
                />
                <Menu.Item
                    name='My Resume'
                />
                <Menu.Item
                    name='Company List'
                />                
            </Menu>
        </div>
    )
}
