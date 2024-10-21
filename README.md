# NBody - Gravitational Simulation

## Overview
In this project, I will simulate the motion of multiple celestial bodies (planets, suns, moons) in a plane, affected by their mutual gravitational interactions. I will create two main classes: `CelestialBody`, which models individual bodies, and `NBody`, which controls the simulation and animates the interactions.

## Background

In 1687, Isaac Newton formulated the laws of motion and universal gravitation. While he could solve the problem of two bodies interacting under gravity, systems with more bodies require numerical methods for approximation. This project applies these principles to simulate gravitational interactions between *N* celestial bodies.

## Project Components

### 1. `CelestialBody.java`: 
- Models individual bodies, including properties like mass, position, and velocity.
- Implements methods to calculate gravitational forces and update the body’s position over time.

### 2. `NBody.java`: 
- Drives the simulation by reading input files, calculating gravitational forces, and animating the results.
- Implements methods to read the simulation’s radius and the celestial bodies' data.

### 3. Simulation & Visualization: 
- I will visualize the simulation as an animation where celestial bodies move based on gravitational forces, calculated at each time step.

## Task Breakdown

### 1. CelestialBody Implementation
- Implement methods to calculate gravitational forces, distances, and update positions.

### 2. NBody Simulation
- Implement methods to read input files (`readRadius` and `readBodies`) and initialize the universe.
- Develop the `main` method to control the simulation and animation.

### 3. Physics
- Apply Newton’s Law of Universal Gravitation to calculate forces between bodies:

  \[
  F = \frac{G \cdot m_1 \cdot m_2}{r^2}
  \]

- Update the bodies’ positions using these forces over time steps.

### 4. Input/Output
- Input files contain information about the universe’s radius and the bodies’ initial states (position, velocity, mass).
- At the end, the final state of all bodies is printed in the same format as the input.

## Example of a Completed Simulation

Here is an example of the simulation running with planets in the solar system:

![Example Animation](p1-figures/planets.gif)

## Deliverables
- **CelestialBody.java**: Class that models individual celestial bodies.
- **NBody.java**: Class that manages the simulation and animation.


## Conclusion
This project allowed me to apply numerical methods for simulating physical systems and gain experience in both Java programming and graphical simulation.
