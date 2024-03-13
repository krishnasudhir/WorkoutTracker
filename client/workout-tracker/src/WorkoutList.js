import React, { useState, useEffect } from 'react';
import axios from 'axios';

const WorkoutList = () => {
  const [workouts, setWorkouts] = useState([]);

  useEffect(() => {
    async function fetchWorkouts() {
      try {
        const response = await axios.get('http://localhost:8080/api/workouts/');
        setWorkouts(response.data);
      } catch (error) {
        console.error('Error fetching workouts:', error);
      }
    }
    
    fetchWorkouts();
  }, []);

  return (
    <div>
      <h2>Workout List</h2>
      <ul>
        {workouts.map(workout => (
          <li key={workout.id}>{workout.name}</li>
        ))}
      </ul>
    </div>
  );
};

export default WorkoutList;
