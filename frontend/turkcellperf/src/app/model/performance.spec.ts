import { Performance } from './performance';

describe('Performance', () => {
  it('should create an instance', () => {
    expect(new Performance(1, 'agentId', 'firstName', 'surname', 'begin', 'end', 'dateInfo', 'excuse', 1, 1)).toBeTruthy();
  });
});
