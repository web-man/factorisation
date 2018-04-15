import React, { Component } from 'react';
import { Table, Checkbox, FormControl, Button } from 'react-bootstrap';
import PriceItem from './PriceItem.js';
import './priceList.css';

class PriceList extends Component {
    constructor() {
        super();
        this.state = {
            posts: [],
            disabled: true,
            checked: false,
            checkboxes: {}
        }

        this.handleChange = this.handleChange.bind(this);
    };

    handleChange(name) {
        const checkboxes = this.state.checkboxes;
        checkboxes[name] = !checkboxes[name];
        this.setState({
            disabled: false,
            checkboxes,
        })
    }

    componentDidMount() {
        fetch('/api/businessYears', {
            headers : { 
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            }
        })
        .then(results => {
            return results.json();
        })
        .then(data => {
            data = [{"id":1,"naziv":"stolica","mera":"kom"},{"id":2,"naziv":"brasno","mera":"kg"},{"id":3,"naziv":"sto","mera":"kom"}]
            const posts = data;
            this.setState({
                posts,
            }); 
        })
    }

    renderPriceList(posts) {
        const checkboxes = this.state.checkboxes;
        const po = posts.map((post) => {
            if (!checkboxes[`check-${post.id}`]) {
                checkboxes[`check-${post.id}`] = false;
            }
            return( 
                <PriceItem
                    key={post.id}
                    post={post}
                    changeCallback={this.handleChange}
                    checked={checkboxes[`check-${post.id}`]}
                />
            );
        })
        return po;
    }

    render() {
        return (
            <div className="price-list">
                <Table striped bordered condensed hover>
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Name</th>
                            <th>Unit</th>
                            <th>Ammunt</th>
                            <th>Add to Cart</th>
                        </tr>
                    </thead>
                    <tbody> 
                        {this.renderPriceList(this.state.posts)}
                        <tr>
                            <td colSpan="4">
                                <p></p>
                            </td>
                            <td className="submit-td">
                                <Button type="submit" disabled>Make Order</Button>
                            </td>
                        </tr>
                    </tbody>
                </Table>
            </div>
        )
    }
}

export default PriceList;